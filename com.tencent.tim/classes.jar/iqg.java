import android.opengl.GLES20;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.program.YUVTextureAliasingProgram;
import com.tencent.av.opengl.program.YUVTextureProgram;
import java.util.HashMap;
import java.util.Map;

public class iqg
{
  static Map<String, TextureProgram> dd = new HashMap();
  
  public static TextureProgram a(int paramInt)
  {
    int j = 1;
    for (;;)
    {
      int i;
      try
      {
        String str = paramInt + "_" + Thread.currentThread().getId();
        localObject1 = (TextureProgram)dd.get(str);
        if (localObject1 == null)
        {
          i = 1;
          if (i != 0) {
            break label173;
          }
          GLES20.glUseProgram(((TextureProgram)localObject1).getId());
          if (irc.lx() != 0)
          {
            i = j;
            break label173;
            localObject1 = new TextureProgram();
            dd.put(str, localObject1);
            return localObject1;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        i = 0;
      }
      finally {}
      Object localObject1 = new YUVTextureProgram();
      continue;
      Object localObject3 = new YUVTextureAliasingProgram();
      continue;
      localObject3 = new iqf();
      continue;
      localObject3 = new iqe();
      continue;
      localObject3 = new iqd();
      continue;
      label173:
      if (i != 0) {
        switch (paramInt)
        {
        }
      }
    }
  }
  
  public static void clear()
  {
    try
    {
      dd.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqg
 * JD-Core Version:    0.7.0.1
 */