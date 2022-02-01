public class anmh
{
  public aeic[] a = new aeic[0];
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SoLoadConfBean:");
    if (this.a != null)
    {
      aeic[] arrayOfaeic = this.a;
      int j = arrayOfaeic.length;
      int i = 0;
      while (i < j)
      {
        aeic localaeic = arrayOfaeic[i];
        if (localaeic != null) {
          localStringBuilder.append("confItem ").append(localaeic.taskId).append(":").append(localaeic.content).append("\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anmh
 * JD-Core Version:    0.7.0.1
 */