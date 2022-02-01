import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity.b;
import java.util.Comparator;

public class kjo
  implements Comparator<ReadinjoySubscriptManagerActivity.b>
{
  public kjo(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  public int a(ReadinjoySubscriptManagerActivity.b paramb1, ReadinjoySubscriptManagerActivity.b paramb2)
  {
    int j = 2147483647;
    int i;
    if (TextUtils.isEmpty(ReadinjoySubscriptManagerActivity.b.a(paramb1)))
    {
      i = 2147483647;
      if (!TextUtils.isEmpty(ReadinjoySubscriptManagerActivity.b.a(paramb2))) {
        break label44;
      }
    }
    for (;;)
    {
      return i - j;
      i = ReadinjoySubscriptManagerActivity.b.a(paramb1).codePointAt(0);
      break;
      label44:
      j = ReadinjoySubscriptManagerActivity.b.a(paramb2).codePointAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kjo
 * JD-Core Version:    0.7.0.1
 */