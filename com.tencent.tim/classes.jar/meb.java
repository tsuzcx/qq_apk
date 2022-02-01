import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import org.jetbrains.annotations.Nullable;

public class meb
  extends mdu
{
  private int aNZ;
  private int aOa;
  private String rowkey;
  
  public meb(ViewGroup paramViewGroup, String paramString1, String paramString2, int paramInt1, int paramInt2, @Nullable String paramString3)
  {
    super(paramViewGroup);
    this.aNZ = paramInt1;
    this.aOa = paramInt2;
    this.rowkey = paramString3;
    paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
    Object localObject = new ColorDrawable(0);
    paramViewGroup.mFailedDrawable = ((Drawable)localObject);
    paramViewGroup.mLoadingDrawable = ((Drawable)localObject);
    paramViewGroup = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20200313/b37cb1e721304575af379f97ce72c115.png", paramViewGroup);
    this.backgroundView.setImageDrawable(paramViewGroup);
    localObject = (TextView)findViewById(2131382118);
    paramViewGroup = (TextView)findViewById(2131382115);
    ((TextView)localObject).setText(paramString1);
    paramString1 = URLDrawable.URLDrawableOptions.obtain();
    localObject = new ColorDrawable(0);
    paramString1.mFailedDrawable = ((Drawable)localObject);
    paramString1.mLoadingDrawable = ((Drawable)localObject);
    paramViewGroup.setBackgroundDrawable(URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/readinjoy/btn_bg_2x.png", paramString1));
    paramViewGroup.setText(paramString2);
    paramViewGroup.setOnClickListener(new mec(this));
    j(paramInt1, paramInt2, paramString3);
  }
  
  protected void aOL()
  {
    i(0, this.aNZ, this.aOa, this.rowkey);
  }
  
  View b(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562921, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     meb
 * JD-Core Version:    0.7.0.1
 */