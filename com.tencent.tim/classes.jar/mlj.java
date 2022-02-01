import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class mlj
  extends auwm<mir.a, mlj.a>
{
  private mlj.b a;
  private ColorDrawable e = new ColorDrawable(BaseApplication.getContext().getResources().getColor(2131167619));
  private int selectPos = -1;
  
  public mlj(Context paramContext)
  {
    super(paramContext);
  }
  
  public mlj.a a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return new mlj.a(paramViewGroup, 2131560187);
    }
    return new mlj.c(paramViewGroup, 2131560188);
  }
  
  public void a(mlj.a parama, int paramInt)
  {
    parama.a(paramInt, (mir.a)getItem(paramInt));
    if (this.a != null) {
      this.a.rP(paramInt);
    }
  }
  
  public void a(mlj.b paramb)
  {
    this.a = paramb;
  }
  
  public int dr(int paramInt)
  {
    mir.a locala = (mir.a)getItem(paramInt);
    if ((locala != null) && (locala.isVideo)) {
      return 1;
    }
    return 0;
  }
  
  public int pz()
  {
    return this.selectPos;
  }
  
  public void rW(int paramInt)
  {
    mir.a locala = (mir.a)getItem(paramInt);
    if ((this.a == null) || (this.a.a(paramInt, locala))) {}
    for (int i = 1;; i = 0)
    {
      if ((this.selectPos != paramInt) && (i != 0))
      {
        i = this.selectPos;
        this.selectPos = paramInt;
        if (this.a != null) {
          this.a.a((mir.a)getItem(this.selectPos));
        }
        notifyItemChanged(i);
        notifyItemChanged(this.selectPos);
      }
      return;
    }
  }
  
  public class a
    extends auwn<mir.a>
  {
    public ImageView jC = (ImageView)getView(2131369717);
    public View maskView = getView(2131371173);
    
    public a(ViewGroup paramViewGroup, int paramInt)
    {
      super(paramInt);
    }
    
    public void a(int paramInt, mir.a parama)
    {
      if (mlj.a(mlj.this) == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        nS(bool);
        this.jC.setOnClickListener(new mlk(this, paramInt));
        c(parama);
        return;
      }
    }
    
    protected URL c(String paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder("albumthumbpreview");
      localStringBuilder.append("://");
      localStringBuilder.append(paramString);
      localStringBuilder.append("#");
      localStringBuilder.append("FLOW_THUMB");
      try
      {
        paramString = new URL(localStringBuilder.toString());
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectPhotoTrace", 2, paramString.getMessage(), paramString);
        }
      }
      return null;
    }
    
    protected void c(mir.a parama)
    {
      try
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jC.getWidth();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jC.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = mlj.a(mlj.this);
        ((URLDrawable.URLDrawableOptions)localObject).mPriority = 2;
        String str = parama.path;
        if (TextUtils.isEmpty(str))
        {
          this.jC.setImageDrawable(mlj.a(mlj.this));
          return;
        }
        localObject = URLDrawable.getDrawable(c(str), (URLDrawable.URLDrawableOptions)localObject);
        if (parama.c != null)
        {
          parama.c.thumbWidth = this.jC.getWidth();
          parama.c.thumbHeight = this.jC.getHeight();
          ((URLDrawable)localObject).setTag(parama.c);
        }
        this.jC.setImageDrawable((Drawable)localObject);
        return;
      }
      catch (Throwable parama)
      {
        QLog.e("RIJUGC.LocalMediaGridAdapter", 1, "load cover failed", parama);
      }
    }
    
    protected void nS(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.maskView.setVisibility(0);
        return;
      }
      this.maskView.setVisibility(8);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(mir.a parama);
    
    public abstract boolean a(int paramInt, mir.a parama);
    
    public abstract void rP(int paramInt);
  }
  
  public class c
    extends mlj.a
  {
    public View li = getView(2131381234);
    public TextView qP = (TextView)getView(2131380671);
    
    public c(ViewGroup paramViewGroup, int paramInt)
    {
      super(paramViewGroup, paramInt);
    }
    
    public void a(int paramInt, mir.a parama)
    {
      super.a(paramInt, parama);
      this.qP.setText(kwz.ba((int)(parama.videoDuration / 1000L)));
    }
    
    protected URL c(String paramString)
    {
      return AsyncImageView.a(paramString, this.jC.getWidth(), this.jC.getHeight(), false);
    }
    
    protected void nS(boolean paramBoolean)
    {
      super.nS(paramBoolean);
      if (paramBoolean)
      {
        this.li.setVisibility(8);
        return;
      }
      this.li.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mlj
 * JD-Core Version:    0.7.0.1
 */