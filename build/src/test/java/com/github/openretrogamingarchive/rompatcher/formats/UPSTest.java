/* Apache 2 License, Copyright (c) 2023 Juan Fuentes, based on Rom Patcher JS by Marc Robledo */
package com.github.openretrogamingarchive.rompatcher.formats;

import com.github.openretrogamingarchive.rompatcher.MarcFile;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class UPSTest {
    Path original = Path.of("test-data","3x3 Eyes - Juuma Houkan (Japan).sfc");
    Path modified = Path.of("test-data","3x3 Eyes - Juuma Houkan (Japan) [T-En by Atomizer_Zero v1.01].sfc");
    Path patch = Path.of("test-data","3x3 Eyes - Juuma Houkan (Japan) [T-En by Atomizer_Zero v1.01].ups");

    @Test
    public void testCreate() throws Exception {
        UPS ups = UPS.createUPSFromFiles(new MarcFile(original), new MarcFile(modified));
        MarcFile export = ups.export();
        Path testPath = Path.of("test.ups");
        export.save(testPath);

        byte[] expected = Files.readAllBytes(patch);
        byte[] actual = Files.readAllBytes(testPath);

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testParse() throws Exception {
        UPS ups = UPS.parseUPSFile(new MarcFile(patch));
        MarcFile export = ups.export();
        Path testPath = Path.of("test.ups");
        export.save(testPath);

        byte[] expected = Files.readAllBytes(patch);
        byte[] actual = Files.readAllBytes(testPath);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testApply() throws Exception {
        UPS ups = UPS.parseUPSFile(new MarcFile(patch));

        MarcFile actualModified = ups.apply(new MarcFile(original), true);
        Path actualModifiedPath = Path.of("modified");
        actualModified.save(actualModifiedPath);

        byte[] expected = Files.readAllBytes(modified);
        byte[] actual = Files.readAllBytes(actualModifiedPath);

        assertArrayEquals(expected, actual);
    }
}
