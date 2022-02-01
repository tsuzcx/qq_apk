import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.io.File;
import java.net.URI;

public class rjc
  extends rja
{
  @NonNull
  public final ptm a;
  @NonNull
  public final String aAJ;
  
  public rjc(int paramInt1, String paramString1, int paramInt2, @NonNull String paramString2, @NonNull ptm paramptm)
  {
    super(paramInt1, paramString1, paramInt2);
    this.aAJ = paramString2;
    this.a = paramptm;
  }
  
  public boolean LD()
  {
    return true;
  }
  
  @NonNull
  public rja.a a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new rjc.a(paramContext, paramViewGroup, null);
  }
  
  @NonNull
  public Class<? extends rja.a> c()
  {
    return rjc.a.class;
  }
  
  public static class a
    extends rja.a<rjc>
  {
    ImageView imageView;
    
    private a(@NonNull Context paramContext, ViewGroup paramViewGroup)
    {
      super(paramViewGroup);
    }
    
    public void a(rjc paramrjc, int paramInt)
    {
      super.a(paramrjc, paramInt);
      Object localObject = paramrjc.a.a;
      if ((localObject != null) && (localObject.length > 0))
      {
        localObject = localObject[0];
        if ((localObject != null) && (((ptm.b)localObject).type == 1))
        {
          localObject = ((ptm.b)localObject).a;
          if (localObject != null)
          {
            float f = rex.b(this.imageView.getResources()) / ((ptm.a)localObject).bkj;
            paramrjc = new File(paramrjc.aAJ, ((ptm.a)localObject).image);
            rgn.a().a(this.imageView.getContext(), this.imageView, paramrjc.toURI().toString(), (int)(((ptm.a)localObject).bkh * f), (int)(((ptm.a)localObject).bki * f), null);
            paramrjc = new RelativeLayout.LayoutParams((int)(((ptm.a)localObject).bkh * f), (int)(((ptm.a)localObject).bki * f));
            if ((((ptm.a)localObject).bkg & 0x1) != 0) {
              paramrjc.addRule(9);
            }
            if ((((ptm.a)localObject).bkg & 0x2) != 0) {
              paramrjc.addRule(10);
            }
            if ((((ptm.a)localObject).bkg & 0x4) != 0) {
              paramrjc.addRule(11);
            }
            if ((((ptm.a)localObject).bkg & 0x8) != 0) {
              paramrjc.addRule(12);
            }
            if ((((ptm.a)localObject).bkg & 0x10) != 0) {
              paramrjc.addRule(14);
            }
            if ((((ptm.a)localObject).bkg & 0x20) != 0) {
              paramrjc.addRule(15);
            }
            if ((((ptm.a)localObject).bkg & 0x40) != 0) {
              paramrjc.addRule(13);
            }
            if ((((ptm.a)localObject).dJ != null) && (((ptm.a)localObject).dJ.length >= 4))
            {
              paramrjc.leftMargin = ((int)(localObject.dJ[0] * f));
              paramrjc.topMargin = ((int)(localObject.dJ[1] * f));
              paramrjc.rightMargin = ((int)(localObject.dJ[2] * f));
              paramrjc.bottomMargin = ((int)(localObject.dJ[3] * f));
            }
            this.imageView.setLayoutParams(paramrjc);
          }
        }
      }
    }
    
    protected View b(@NonNull Context paramContext, ViewGroup paramViewGroup)
    {
      paramViewGroup = new RelativeLayout(paramContext);
      paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      this.imageView = new ImageView(paramContext);
      this.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramViewGroup.addView(this.imageView);
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rjc
 * JD-Core Version:    0.7.0.1
 */