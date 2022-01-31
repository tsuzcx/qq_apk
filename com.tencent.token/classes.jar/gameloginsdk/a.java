package gameloginsdk;

import java.util.LinkedList;

class a
{
  LinkedList a = new LinkedList();
  
  public void a(byte[] paramArrayOfByte)
  {
    this.a.addFirst(new b(paramArrayOfByte));
  }
  
  public byte[] a()
  {
    b localb = (b)this.a.removeFirst();
    if (localb == null) {
      return null;
    }
    return localb.a;
  }
  
  public boolean b(byte[] paramArrayOfByte)
  {
    return this.a.contains(new b(paramArrayOfByte));
  }
  
  public byte[] b()
  {
    b localb = (b)this.a.removeLast();
    if (localb == null) {
      return null;
    }
    return localb.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     gameloginsdk.a
 * JD-Core Version:    0.7.0.1
 */