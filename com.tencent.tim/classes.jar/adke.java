import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class adke
{
  public static adkd a(adkf paramadkf, int paramInt)
  {
    if (paramadkf == null) {
      throw new RuntimeException("params can not be null!");
    }
    Object localObject;
    switch (paramadkf.keyType)
    {
    default: 
      localObject = new adkh(paramInt);
    }
    for (;;)
    {
      QLog.i("KeyingManager", 1, "getKeying keying: " + localObject + "  params: " + paramadkf.toString());
      return localObject;
      localObject = new adjx(paramInt);
      continue;
      localObject = new adkj(paramInt);
      continue;
      localObject = new adkb(paramInt);
      continue;
      localObject = new adkc(paramInt);
      continue;
      if (TextUtils.isEmpty(paramadkf.fragmentShader)) {
        break;
      }
      localObject = new adjy(paramInt, paramadkf.fragmentShader);
    }
    throw new RuntimeException("fragmentShader can not be empty!");
  }
  
  public static adkf a(int paramInt)
  {
    return new adkf(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adke
 * JD-Core Version:    0.7.0.1
 */