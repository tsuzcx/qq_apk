import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class med
  extends mdu
{
  private int aNZ;
  private int aOa;
  private String rowkey;
  
  @SuppressLint({"DefaultLocale"})
  public med(ViewGroup paramViewGroup, long paramLong, String paramString1, @NotNull mdp parammdp, String paramString2, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString3)
  {
    super(paramViewGroup);
    this.aNZ = paramInt1;
    this.aOa = paramInt2;
    this.rowkey = paramString3;
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    Object localObject2 = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
    localObject1 = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20200402/3aeb63b5612d43a3b555782b6d77b0e2.png", (URLDrawable.URLDrawableOptions)localObject1);
    this.backgroundView.setImageDrawable((Drawable)localObject1);
    TextView localTextView1 = (TextView)findViewById(2131382110);
    TextView localTextView2 = (TextView)findViewById(2131382112);
    TextView localTextView3 = (TextView)findViewById(2131382117);
    TextView localTextView4 = (TextView)findViewById(2131382118);
    localObject2 = (TextView)findViewById(2131382115);
    ImageView localImageView = (ImageView)findViewById(2131382107);
    if (paramLong % 100L == 0L) {}
    for (localObject1 = String.valueOf(paramLong / 100L);; localObject1 = String.valueOf((float)paramLong / 100.0F))
    {
      localTextView1.setText((CharSequence)localObject1);
      localTextView3.setText(parammdp.nickName);
      localTextView4.setText(parammdp.wording);
      ((TextView)localObject2).setText(paramString2);
      localTextView2.setText(paramString1);
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramString2 = new ColorDrawable(0);
      paramString1.mFailedDrawable = paramString2;
      paramString1.mLoadingDrawable = paramString2;
      paramString1.mRequestWidth = 414;
      paramString1.mRequestHeight = 148;
      ((TextView)localObject2).setBackgroundDrawable(URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/readinjoy/btn_bg_2x.png", paramString1));
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramViewGroup = paramViewGroup.getContext().getResources().getDrawable(2130846334);
      paramString1.mFailedDrawable = paramViewGroup;
      paramString1.mLoadingDrawable = paramViewGroup;
      paramViewGroup = URLDrawable.getDrawable(parammdp.avatarUrl, paramString1);
      paramViewGroup.setDecodeHandler(aqbn.b);
      localImageView.setImageDrawable(paramViewGroup);
      ((TextView)localObject2).setOnClickListener(new mee(this, paramInt1, paramInt2, paramInt3));
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
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562922, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     med
 * JD-Core Version:    0.7.0.1
 */