package moai.io;

import java.nio.IntBuffer;
import okio.Buffer;

public class ExpandableIntBuffer
{
  private Buffer buffer = new Buffer();
  
  public static ExpandableIntBuffer allocate()
  {
    return new ExpandableIntBuffer();
  }
  
  public IntBuffer finish()
  {
    IntBuffer localIntBuffer = IntBuffer.allocate((int)this.buffer.size() / 4);
    while (!this.buffer.exhausted()) {
      localIntBuffer.put(this.buffer.readInt());
    }
    localIntBuffer.flip();
    return localIntBuffer;
  }
  
  public void put(int paramInt)
  {
    this.buffer.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.ExpandableIntBuffer
 * JD-Core Version:    0.7.0.1
 */