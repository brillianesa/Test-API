package id.amartek.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import id.amartek.app.model.Region;
import id.amartek.app.repository.RegionRepository;
import id.amartek.app.service.RegionServices;

@SpringBootTest
public class RegionTest {
    @Autowired
    private RegionServices regionServices;

    @Test
    public void Save() {
        // Arrange
        Boolean expected = true;
        Region region = new Region();
        region.setName("NEW REGION");

        // Act
        Boolean result = regionServices.Save(region);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void Delete() {
        Boolean expected = true;
        Boolean result = regionServices.Delete(6);
        assertEquals(expected, result);
    }

}
