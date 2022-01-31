package android.support.v4.net;

import java.io.FileDescriptor;
import java.net.DatagramSocket;
import java.net.Socket;

class DatagramSocketWrapper
  extends Socket
{
  DatagramSocketWrapper(DatagramSocket paramDatagramSocket, FileDescriptor paramFileDescriptor)
  {
    super(new DatagramSocketWrapper.DatagramSocketImplWrapper(paramDatagramSocket, paramFileDescriptor));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.net.DatagramSocketWrapper
 * JD-Core Version:    0.7.0.1
 */