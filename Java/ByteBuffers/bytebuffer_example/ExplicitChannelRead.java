// Use NIO to read a text file.
import java.io.*;
import java.nio.*;
import java.nio.channels.*;


public class ExplicitChannelRead {
    public static void main(String args[]) {
        FileInputStream fIn;
        FileChannel fChan;
        long fSize;
        ByteBuffer mBuf;

        try {
            // First, open a file for input.
            fIn = new FileInputStream("test.txt");
            
            // Next, obtain a channel to that file.
            fChan = fIn.getChannel();

            // Now, get the file's size.
            fSize = fChan.size();

            // Allocate a buffer of the necessary size.
            mBuf = ByteBuffer.allocate((int)fSize);

            // Read the file into the buffer.
            fChan.read(mBuf);

            // Rewind the buffer so that it can be read.
            // Rewinds this buffer. The position is set to zero and the mark is
            // discarded.
            mBuf.rewind();

            // Read bytes from the buffer.
            for(int i=0; i < fSize; i++)
                System.out.print((char)mBuf.get());

            System.out.println();

            // close channel and file
            fChan.close();
            fIn.close();

        } catch (IOException exc) {
            System.out.println(exc);
            System.exit(1);
        }
    }
}
