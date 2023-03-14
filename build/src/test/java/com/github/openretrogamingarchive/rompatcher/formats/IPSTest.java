package com.github.openretrogamingarchive.rompatcher.formats;

import com.github.openretrogamingarchive.rompatcher.MarcFile;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IPSTest {
    Path original = Path.of("test-data","3x3 Eyes - Juuma Houkan (Japan).sfc");
    Path modified = Path.of("test-data","3x3 Eyes - Juuma Houkan (Japan) [T-En by Atomizer_Zero v1.01].sfc");
    Path patch = Path.of("test-data","3x3 Eyes - Juuma Houkan (Japan) [T-En by Atomizer_Zero v1.01].ips");

    @Test
    public void testCreate() throws Exception {
        IPS ips = IPS.createIPSFromFiles(new MarcFile(original), new MarcFile(modified));
        MarcFile export = ips.export();
        Path testPath = Path.of("test.ips");
        export.save(testPath);

        byte[] expected = Files.readAllBytes(patch);
        byte[] actual = Files.readAllBytes(testPath);

        assertArrayEquals(expected, actual);
    }
    @Test
    public void testParse() throws Exception {
        IPS ips = IPS.parseIPSFile(new MarcFile(patch));
        MarcFile export = ips.export();
        Path testPath = Path.of("test.bps");
        export.save(testPath);

        byte[] expected = Files.readAllBytes(patch);
        byte[] actual = Files.readAllBytes(testPath);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testApply() throws Exception {
        IPS ips = IPS.parseIPSFile(new MarcFile(patch));

        MarcFile actualModified = ips.apply(new MarcFile(original));
        Path actualModifiedPath = Path.of("modified");
        actualModified.save(actualModifiedPath);

        byte[] expected = Files.readAllBytes(modified);
        byte[] actual = Files.readAllBytes(actualModifiedPath);

        assertArrayEquals(expected, actual);
    }
}
