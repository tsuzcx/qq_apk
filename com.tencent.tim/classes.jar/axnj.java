import com.tencent.tavcut.bean.Size;

class axnj
  implements axnn
{
  public int Rn()
  {
    return 1920;
  }
  
  public int Ro()
  {
    return ((Integer)axnm.a(Integer.valueOf(3145728), Integer.valueOf(4194304), Integer.valueOf(5242880))).intValue();
  }
  
  public int Rp()
  {
    return 30;
  }
  
  public Size a(Size paramSize)
  {
    int i = ((Integer)axnm.a(Integer.valueOf(960), Integer.valueOf(1280), Integer.valueOf(1920))).intValue();
    Size localSize = new Size(0, 0);
    double d = paramSize.getWidth() / paramSize.getHeight();
    if (paramSize.getWidth() > paramSize.getHeight())
    {
      localSize.setWidth(Math.min(paramSize.getWidth(), i));
      localSize.setHeight(axnm.g(localSize.getWidth() / d));
      return localSize;
    }
    localSize.setHeight(Math.min(paramSize.getHeight(), i));
    localSize.setWidth(axnm.g(d * localSize.getHeight()));
    return localSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axnj
 * JD-Core Version:    0.7.0.1
 */