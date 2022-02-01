import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class mdx
  extends mdu
{
  public mdx(ViewGroup paramViewGroup, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, @Nullable skj paramskj)
  {
    super(paramViewGroup);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20200313/4892c273234b4f39833f389671c1b1fa.png", (URLDrawable.URLDrawableOptions)localObject);
    this.backgroundView.setImageDrawable((Drawable)localObject);
    localObject = (TextView)findViewById(2131382115);
    ((TextView)localObject).setOnClickListener(new mdy(this, paramBoolean, paramskj, paramString, paramInt1, paramInt2, paramViewGroup));
    paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
    paramString = new ColorDrawable(0);
    paramViewGroup.mFailedDrawable = paramString;
    paramViewGroup.mLoadingDrawable = paramString;
    ((TextView)localObject).setBackgroundDrawable(URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/readinjoy/btn_bg_2x.png", paramViewGroup));
  }
  
  View b(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562919, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mdx
 * JD-Core Version:    0.7.0.1
 */