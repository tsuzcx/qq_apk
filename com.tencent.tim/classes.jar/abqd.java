import android.content.Context;

public abstract class abqd
{
  void a(String paramString1, String paramString2, abqe paramabqe)
  {
    if (("destroy".equals(paramString2)) && (paramabqe != null))
    {
      onDestroy();
      paramabqe.a(this);
    }
  }
  
  abstract int am(Context paramContext);
  
  abstract String getNameSpace();
  
  abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqd
 * JD-Core Version:    0.7.0.1
 */