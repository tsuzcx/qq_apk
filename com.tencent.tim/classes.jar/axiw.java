import android.view.View;

public final class axiw
{
  public static boolean Y(View paramView)
  {
    Object localObject = paramView.getTag(2131362326);
    long l = System.currentTimeMillis();
    paramView.setTag(2131362326, Long.valueOf(l));
    return ((localObject instanceof Long)) && (Math.abs(l - ((Long)localObject).longValue()) <= 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axiw
 * JD-Core Version:    0.7.0.1
 */