import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import org.jetbrains.annotations.Nullable;

public class mdz
  extends mdu
{
  private int aNZ;
  private int aOa;
  private String rowkey;
  
  @SuppressLint({"DefaultLocale"})
  public mdz(ViewGroup paramViewGroup, long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString3)
  {
    super(paramViewGroup);
    this.ba = paramViewGroup;
    this.aNZ = paramInt1;
    this.aOa = paramInt2;
    this.rowkey = paramString3;
    TextView localTextView2 = (TextView)findViewById(2131382110);
    TextView localTextView1 = (TextView)findViewById(2131382115);
    ((TextView)findViewById(2131382112)).setText(paramString2);
    if (paramLong % 100L == 0L) {}
    for (paramViewGroup = String.valueOf(paramLong / 100L);; paramViewGroup = String.valueOf((float)paramLong / 100.0F))
    {
      localTextView2.setText(paramViewGroup);
      paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
      paramString2 = new ColorDrawable(0);
      paramViewGroup.mFailedDrawable = paramString2;
      paramViewGroup.mLoadingDrawable = paramString2;
      paramViewGroup = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20200402/b05b6be7ab8245758e169dba373bfcbb.png", paramViewGroup);
      this.backgroundView.setImageDrawable(paramViewGroup);
      paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
      paramString2 = new ColorDrawable(0);
      paramViewGroup.mFailedDrawable = paramString2;
      paramViewGroup.mLoadingDrawable = paramString2;
      paramViewGroup.mRequestWidth = 414;
      paramViewGroup.mRequestHeight = 148;
      localTextView1.setBackgroundDrawable(URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/readinjoy/btn_bg_2x.png", paramViewGroup));
      localTextView1.setText(paramString1);
      localTextView1.setOnClickListener(new mea(this, paramInt1, paramInt2, paramInt3));
      j(paramInt1, paramInt2, paramString3);
      return;
    }
  }
  
  protected void aOL()
  {
    i(0, this.aNZ, this.aOa, this.rowkey);
  }
  
  View b(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562920, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mdz
 * JD-Core Version:    0.7.0.1
 */