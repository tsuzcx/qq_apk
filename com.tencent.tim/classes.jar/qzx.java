import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.mobileqq.theme.ThemeUtil;

public class qzx
  extends rsd
{
  public static final String KEY = "PlaceholderSegment";
  private String azh;
  private qyd b;
  private int bpi;
  private int imageRes;
  private String wording;
  
  public qzx(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.isDisplay = false;
    this.azh = paramString1;
    this.wording = paramString2;
    this.imageRes = paramInt1;
    this.bpi = paramInt2;
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramqyd.get(2131375195);
    ImageView localImageView = (ImageView)paramqyd.get(2131375196);
    if (TextUtils.isEmpty(this.wording))
    {
      paramViewGroup.setText(acfp.m(2131709672) + plr.asY + "\n拍摄一段小视频，分享眼前的世界");
      QQStoryContext.a();
      if (!ThemeUtil.isNowThemeIsNight(QQStoryContext.c(), false, null)) {
        break label104;
      }
      localImageView.setImageResource(this.bpi);
    }
    for (;;)
    {
      return paramqyd.getItemView();
      paramViewGroup.setText(this.wording);
      break;
      label104:
      localImageView.setImageResource(this.imageRes);
    }
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    this.b = new qyd(LayoutInflater.from(this.context).inflate(2131561832, paramViewGroup, false));
    return this.b;
  }
  
  protected void bqN()
  {
    rsd localrsd = a().a(this.azh);
    if ((localrsd == null) || (localrsd.getCount() == 0))
    {
      setDisplay(true);
      return;
    }
    setDisplay(false);
  }
  
  protected void bqO()
  {
    bqN();
  }
  
  public void bqo()
  {
    bqN();
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public String getKey()
  {
    return "PlaceholderSegment";
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.b == null) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.b.get(2131375196);
    } while (localImageView == null);
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.c(), false, null))
    {
      localImageView.setImageResource(this.bpi);
      return;
    }
    localImageView.setImageResource(this.imageRes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     qzx
 * JD-Core Version:    0.7.0.1
 */