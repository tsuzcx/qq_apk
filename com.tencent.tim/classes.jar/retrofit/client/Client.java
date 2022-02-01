package retrofit.client;

import java.io.IOException;

public abstract interface Client
{
  public abstract Response execute(Request paramRequest)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     retrofit.client.Client
 * JD-Core Version:    0.7.0.1
 */