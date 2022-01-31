import android.support.annotation.NonNull;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class uoi
  extends uoc
{
  protected int a;
  protected int b;
  
  public uoi(@NonNull String[] paramArrayOfString)
  {
    super(paramArrayOfString);
    paramArrayOfString = (uvt)uwa.a(10);
    this.jdField_a_of_type_Int = ((Integer)paramArrayOfString.b("StoryMyCacheCountMax", Integer.valueOf(200))).intValue();
    this.b = ((Integer)paramArrayOfString.b("StoryMyCacheCountNormal", Integer.valueOf(100))).intValue();
  }
  
  protected void a(String[] paramArrayOfString, uod paramuod)
  {
    int m = paramArrayOfString.length;
    int i = 0;
    String str;
    if (i < m)
    {
      str = paramArrayOfString[i];
      if (!a(str, this.jdField_a_of_type_Int)) {}
    }
    for (;;)
    {
      i += 1;
      break;
      File localFile = new File(str);
      double d = a(localFile);
      File[] arrayOfFile = localFile.listFiles();
      ArrayList localArrayList = new ArrayList();
      int k = arrayOfFile.length;
      int j = 0;
      while (j < k)
      {
        localArrayList.add(new uoj(this, arrayOfFile[j]));
        j += 1;
      }
      Collections.sort(localArrayList);
      int n = localArrayList.size();
      k = 0;
      j = 0;
      while (j < n)
      {
        if (j % 150 == 0) {}
        try
        {
          Thread.sleep(100L);
          if ((j % 20 == 0) && (a(str, this.b))) {
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
          a(((uoj)localArrayList.get(j)).a);
          k += 1;
          j += 1;
        }
      }
      paramuod.jdField_a_of_type_Double = (d - a(localFile) + paramuod.jdField_a_of_type_Double);
      paramuod.jdField_a_of_type_Int += k;
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    paramString = new File(paramString).listFiles();
    if (paramString == null) {}
    while (paramString.length <= paramInt) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uoi
 * JD-Core Version:    0.7.0.1
 */