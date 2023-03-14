/* Apache 2 License, Copyright (c) 2023 Juan Fuentes, based on Rom Patcher JS by Marc Robledo */
package com.github.openretrogamingarchive.rompatcher.formats;

import com.github.openretrogamingarchive.rompatcher.MarcFile;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BPSTest {
    Path original = Path.of("test-data","3x3 Eyes - Juuma Houkan (Japan).sfc");
    Path modified = Path.of("test-data","3x3 Eyes - Juuma Houkan (Japan) [T-En by Atomizer_Zero v1.01].sfc");
    Path linearPatch = Path.of("test-data","3x3 Eyes - Juuma Houkan (Japan) [T-En by Atomizer_Zero v1.01]-linear.bps");
    Path deltaPatch = Path.of("test-data","3x3 Eyes - Juuma Houkan (Japan) [T-En by Atomizer_Zero v1.01]-delta.bps");
    @Test
    public void testCreateLinear() throws Exception {
        BPS bps = BPS.createBPSFromFiles(new MarcFile(original), new MarcFile(modified), false);
        MarcFile export = bps.export();
        Path testPath = Path.of("test.bps");
        export.save(testPath);

        byte[] expected = Files.readAllBytes(linearPatch);
        byte[] actual = Files.readAllBytes(testPath);

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testLoadLinear() throws Exception {
        BPS bps = BPS.parseBPSFile(new MarcFile(linearPatch));
        MarcFile export = bps.export();
        Path testPath = Path.of("test.bps");
        export.save(testPath);

        byte[] expected = Files.readAllBytes(linearPatch);
        byte[] actual = Files.readAllBytes(testPath);

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testCreateDelta() throws Exception {
        BPS bps = BPS.createBPSFromFiles(new MarcFile(original), new MarcFile(modified), true);
        MarcFile export = bps.export();
        Path testPath = Path.of("test.bps");
        export.save(testPath);

        byte[] expected = Files.readAllBytes(deltaPatch);
        byte[] actual = Files.readAllBytes(testPath);

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testLoadDelta() throws Exception {
        BPS bps = BPS.parseBPSFile(new MarcFile(deltaPatch));
        MarcFile export = bps.export();
        Path testPath = Path.of("test.bps");
        export.save(testPath);

        byte[] expected = Files.readAllBytes(deltaPatch);
        byte[] actual = Files.readAllBytes(testPath);

        assertArrayEquals(expected, actual);
    }
}
