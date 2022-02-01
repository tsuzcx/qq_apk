import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class aqeb
{
  private aqdx b;
  private Handler handler;
  private BitmapDrawable j = new BitmapDrawable();
  private Context mContext;
  private boolean mExitTasksEarly;
  private boolean mFadeInBitmap;
  protected int mImageHeight;
  protected int mImageWidth;
  private Map<View, aqeb.c> nZ = new WeakHashMap();
  
  public aqeb(Context paramContext)
  {
    this.mContext = paramContext;
    this.b = new aqdx(aqey.getMemoryClass(paramContext) / 8);
  }
  
  private aqeb.b a(View paramView)
  {
    if (paramView != null)
    {
      aqeb.c localc = (aqeb.c)this.nZ.get(paramView);
      if (localc != null) {
        paramView = localc.jdField_a_of_type_Aqeb$a;
      }
      while ((paramView instanceof aqeb.a))
      {
        return ((aqeb.a)paramView).a();
        if ((paramView instanceof ImageView)) {
          paramView = ((ImageView)paramView).getDrawable();
        } else {
          paramView = paramView.getBackground();
        }
      }
    }
    return null;
  }
  
  private void a(boolean paramBoolean, View paramView, Drawable paramDrawable, aqeb.c paramc)
  {
    Object localObject = paramDrawable;
    if (this.mFadeInBitmap)
    {
      localObject = paramDrawable;
      if (paramBoolean)
      {
        localObject = paramDrawable;
        if (!(paramDrawable instanceof AnimationDrawable))
        {
          localObject = paramDrawable;
          if (paramDrawable != null)
          {
            localObject = new TransitionDrawable(new Drawable[] { new ColorDrawable(17170445), paramDrawable });
            ((TransitionDrawable)localObject).startTransition(200);
          }
        }
      }
    }
    paramDrawable = null;
    if (paramc != null) {
      paramDrawable = paramc.jdField_a_of_type_Aqea;
    }
    if (paramDrawable != null)
    {
      paramDrawable.d(paramView, (Drawable)localObject);
      return;
    }
    if ((paramView instanceof ImageView))
    {
      ((ImageView)paramView).setImageDrawable((Drawable)localObject);
      return;
    }
    paramView.setBackgroundDrawable((Drawable)localObject);
  }
  
  public aqdx a()
  {
    return this.b;
  }
  
  public void kh(int paramInt1, int paramInt2)
  {
    this.mImageWidth = paramInt1;
    this.mImageHeight = paramInt2;
  }
  
  static class a
    extends BitmapDrawable
  {
    private final WeakReference<aqeb.b> bitmapWorkerTaskReference;
    
    public aqeb.b a()
    {
      return (aqeb.b)this.bitmapWorkerTaskReference.get();
    }
  }
  
  public class b
    extends AsyncTask<Object, Void, Drawable>
  {
    private boolean cTK;
    private Object data;
    private final WeakReference<View> imageViewReference;
    
    private View cy()
    {
      View localView = (View)this.imageViewReference.get();
      if (!this.cTK) {}
      while (this == aqeb.a(this.this$0, localView)) {
        return localView;
      }
      return null;
    }
    
    public Drawable a(Object... paramVarArgs)
    {
      this.data = paramVarArgs[0];
      String str = String.valueOf(this.data);
      aqdz localaqdz = (aqdz)paramVarArgs[1];
      this.cTK = ((Boolean)paramVarArgs[2]).booleanValue();
      if (((aqeb.a(this.this$0) == null) || (isCancelled()) || (cy() == null) || (aqeb.a(this.this$0))) || ((0 == 0) && (!isCancelled()) && (cy() != null) && (!aqeb.a(this.this$0)))) {}
      for (;;)
      {
        try
        {
          paramVarArgs = localaqdz.aT();
          if ((aqeb.a(this.this$0) != null) && (paramVarArgs != null)) {
            aqeb.a(this.this$0).f(str, paramVarArgs);
          }
          return paramVarArgs;
        }
        catch (OutOfMemoryError paramVarArgs)
        {
          if (aqeb.a(this.this$0) != null) {
            aqeb.a(this.this$0).edy();
          }
          System.gc();
          Thread.yield();
          try
          {
            paramVarArgs = localaqdz.aT();
          }
          catch (OutOfMemoryError paramVarArgs)
          {
            QLog.w("ImageWorker", 2, "OutOfMemoryError!!!!!");
          }
        }
        paramVarArgs = null;
      }
    }
    
    public void aa(Drawable paramDrawable)
    {
      View localView = cy();
      aqeb.c localc = (aqeb.c)aqeb.a(this.this$0).remove(localView);
      if ((isCancelled()) || (aqeb.a(this.this$0))) {
        paramDrawable = null;
      }
      if (localView != null)
      {
        if (paramDrawable != null) {
          break label72;
        }
        if ((localc != null) && (localc.a != null)) {
          localc.a.d(localView, null);
        }
      }
      return;
      label72:
      aqeb.a(this.this$0, this.cTK, localView, paramDrawable, localc);
    }
  }
  
  static class c
  {
    aqea jdField_a_of_type_Aqea;
    aqeb.a jdField_a_of_type_Aqeb$a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqeb
 * JD-Core Version:    0.7.0.1
 */