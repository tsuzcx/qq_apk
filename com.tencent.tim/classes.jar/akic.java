import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class akic
  extends akhv
{
  public akic(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(akhv.a parama)
  {
    return 3;
  }
  
  public akhv.a a()
  {
    return new akic.a();
  }
  
  public View a(ViewGroup paramViewGroup, akhv.a parama)
  {
    parama = (akic.a)parama;
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(2131561485, paramViewGroup, false);
    parama.qp = ((TextView)paramViewGroup.findViewById(2131380966));
    parama.jF = ((ImageView)paramViewGroup.findViewById(2131369717));
    parama.BL = ((ImageView)paramViewGroup.findViewById(2131369837));
    parama.Fq = paramViewGroup.findViewById(2131366896);
    parama.Fr = paramViewGroup.findViewById(2131366897);
    return paramViewGroup;
  }
  
  public String b(akhv.a parama)
  {
    return ((akjg)((akic.a)parama).b).bTv;
  }
  
  public void h(akhv.a parama)
  {
    parama = (akic.a)parama;
    Object localObject1 = (akjg)parama.b;
    label69:
    int j;
    if (((akjg)localObject1).videoCount > 1)
    {
      parama.Fq.setVisibility(0);
      parama.Fr.setVisibility(0);
      parama.qp.setMovementMethod(LinkMovementMethod.getInstance());
      if (!TextUtils.isEmpty(((akjg)localObject1).agQ)) {
        break label307;
      }
      parama.qp.setVisibility(8);
      j = rpq.dip2px(this.mContext, 200.0F);
      if ((((akjg)localObject1).width <= 0) || (((akjg)localObject1).height <= 0)) {
        break label414;
      }
    }
    label414:
    for (int i = ((akjg)localObject1).height * j / ((akjg)localObject1).width;; i = j)
    {
      if (i * 3 > j * 4) {
        i = j * 4 / 3;
      }
      for (;;)
      {
        for (;;)
        {
          Object localObject2;
          if (!TextUtils.equals((String)parama.jF.getTag(2131379238), ((akjg)localObject1).faceUrl))
          {
            parama.jF.setTag(2131379238, ((akjg)localObject1).faceUrl);
            localObject2 = (FrameLayout.LayoutParams)parama.jF.getLayoutParams();
            if (localObject2 != null) {
              break label330;
            }
            localObject2 = new FrameLayout.LayoutParams(j, i);
            parama.jF.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          try
          {
            for (;;)
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.mContext.getResources().getDrawable(2130846397);
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.mContext.getResources().getDrawable(2130846397);
              localObject1 = URLDrawable.getDrawable(((akjg)localObject1).faceUrl, (URLDrawable.URLDrawableOptions)localObject2);
              ((URLDrawable)localObject1).setTag(aqbn.d(j, i, aqcx.dip2px(this.mContext, 3.0F)));
              ((URLDrawable)localObject1).setDecodeHandler(aqbn.f);
              parama.jF.setImageDrawable((Drawable)localObject1);
              return;
              parama.Fq.setVisibility(8);
              parama.Fr.setVisibility(8);
              break;
              label307:
              parama.qp.setVisibility(0);
              parama.qp.setText(((akjg)localObject1).agQ);
              break label69;
              label330:
              if ((((FrameLayout.LayoutParams)localObject2).width != j) || (((FrameLayout.LayoutParams)localObject2).height != i))
              {
                ((FrameLayout.LayoutParams)localObject2).width = j;
                ((FrameLayout.LayoutParams)localObject2).height = i;
                parama.jF.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              }
            }
          }
          catch (Exception localException)
          {
            do
            {
              parama.jF.setImageDrawable(this.mContext.getResources().getDrawable(2130846397));
            } while (!QLog.isColorLevel());
            QLog.i("BaseMomentItemBuilder", 1, localException.toString());
            return;
          }
        }
      }
    }
  }
  
  public class a
    extends akhv.a
  {
    public ImageView BL;
    public View Fq;
    public View Fr;
    public ImageView jF;
    public TextView qp;
    
    public a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akic
 * JD-Core Version:    0.7.0.1
 */