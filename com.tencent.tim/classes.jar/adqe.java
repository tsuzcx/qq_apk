import java.util.ArrayList;

class adqe
  implements adqb.b
{
  adqe(adqb paramadqb) {}
  
  public void b(adqb.e parame, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < parame.callback.size())
    {
      adqb.a locala = (adqb.a)parame.callback.get(i);
      if (locala != null) {
        locala.b(paramBoolean, parame.lastModifiedTime, paramArrayOfByte);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adqe
 * JD-Core Version:    0.7.0.1
 */