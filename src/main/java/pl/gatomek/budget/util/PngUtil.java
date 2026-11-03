package pl.gatomek.budget.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PngUtil {

    public static byte[] reduce(byte[] content) throws IOException {
        BufferedImage original = ImageIO.read(new ByteArrayInputStream(content));

        BufferedImage reducedImage = new BufferedImage(
                original.getWidth(),
                original.getHeight(),
                BufferedImage.TYPE_BYTE_INDEXED
        );

        Graphics2D g2d = reducedImage.createGraphics();
        g2d.drawImage(original, 0, 0, null);
        g2d.dispose();

        BufferedImage reducedImage2 = new BufferedImage(
                original.getWidth(),
                original.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY
        );

        Graphics2D g2d2 = reducedImage2.createGraphics();
        g2d2.drawImage(reducedImage, 0, 0, null);
        g2d2.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(reducedImage2, "png", baos);
        return baos.toByteArray();
    }
}
