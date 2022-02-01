import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract interface npo
{
  public abstract InputStream a(String paramString)
    throws IOException;
  
  public abstract List<String> list()
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     npo
 * JD-Core Version:    0.7.0.1
 */