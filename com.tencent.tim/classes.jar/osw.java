import UserGrowth.stNotificationRedDot;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.view.RedDotBubblePopupWindow.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.ArrayList<LUserGrowth.stNotificationRedDot;>;
import java.util.Iterator;

public class osw
  extends PopupWindow
  implements View.OnClickListener
{
  private static final int bfL = aqnm.dip2px(8.0F);
  private osw.a a;
  private View contentView;
  private Context mContext;
  public Handler mMainHandler = new Handler(Looper.getMainLooper());
  private ArrayList<View> mf = new ArrayList();
  private TextView vx;
  private TextView vy;
  private TextView vz;
  
  public osw(Context paramContext, osw.a parama)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.a = parama;
  }
  
  private void b(View paramView, ArrayList<stNotificationRedDot> paramArrayList)
  {
    paramView.findViewById(2131370713).setOnClickListener(this);
    this.mf.clear();
    this.mf.add(paramView.findViewById(2131370440));
    this.mf.add(paramView.findViewById(2131366707));
    this.mf.add(paramView.findViewById(2131372749));
    this.vx = ((TextView)paramView.findViewById(2131370447));
    this.vy = ((TextView)paramView.findViewById(2131366710));
    this.vz = ((TextView)paramView.findViewById(2131372750));
    String str = "";
    Object localObject1 = "";
    paramView = "";
    Object localObject2 = paramView;
    Object localObject3 = localObject1;
    Object localObject4 = str;
    if (paramArrayList != null)
    {
      Iterator localIterator = paramArrayList.iterator();
      paramArrayList = str;
      localObject2 = paramView;
      localObject3 = localObject1;
      localObject4 = paramArrayList;
      if (localIterator.hasNext())
      {
        localObject2 = (stNotificationRedDot)localIterator.next();
        if (((stNotificationRedDot)localObject2).type == 2)
        {
          localObject2 = ((stNotificationRedDot)localObject2).text;
          paramArrayList = (ArrayList<stNotificationRedDot>)localObject1;
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      localObject1 = paramArrayList;
      paramArrayList = (ArrayList<stNotificationRedDot>)localObject2;
      break;
      if (((stNotificationRedDot)localObject2).type == 3)
      {
        localObject2 = ((stNotificationRedDot)localObject2).text;
        localObject1 = paramArrayList;
        paramArrayList = (ArrayList<stNotificationRedDot>)localObject2;
      }
      else if (((stNotificationRedDot)localObject2).type == 1)
      {
        paramView = ((stNotificationRedDot)localObject2).text;
        localObject2 = paramArrayList;
        paramArrayList = (ArrayList<stNotificationRedDot>)localObject1;
        localObject1 = localObject2;
        continue;
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          ((View)this.mf.get(0)).setVisibility(8);
          if (!TextUtils.isEmpty(localObject3)) {
            break label344;
          }
          ((View)this.mf.get(1)).setVisibility(8);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label371;
          }
          ((View)this.mf.get(2)).setVisibility(8);
          return;
          ((View)this.mf.get(0)).setVisibility(0);
          this.vx.setText((CharSequence)localObject4);
          break;
          label344:
          ((View)this.mf.get(1)).setVisibility(0);
          this.vy.setText(localObject3);
        }
        label371:
        ((View)this.mf.get(2)).setVisibility(0);
        this.vz.setText((CharSequence)localObject2);
      }
      else
      {
        localObject2 = paramArrayList;
        paramArrayList = (ArrayList<stNotificationRedDot>)localObject1;
        localObject1 = localObject2;
      }
    }
  }
  
  private void bgS()
  {
    Iterator localIterator = this.mf.iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      Object localObject = (View)localIterator.next();
      if (((View)localObject).getVisibility() != 0) {
        break label87;
      }
      localObject = ((View)localObject).getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        if (i == 0)
        {
          j = 0;
          label66:
          ((ViewGroup.MarginLayoutParams)localObject).leftMargin = j;
        }
      }
      else
      {
        i += 1;
      }
    }
    label87:
    for (;;)
    {
      break;
      j = bfL;
      break label66;
      return;
    }
  }
  
  public void a(View paramView, ArrayList<stNotificationRedDot> paramArrayList)
  {
    if (isShowing()) {
      dismiss();
    }
    if (paramView == null) {
      return;
    }
    if (this.contentView == null)
    {
      setBackgroundDrawable(new BitmapDrawable());
      this.contentView = LayoutInflater.from(this.mContext).inflate(2131560190, null);
      b(this.contentView, paramArrayList);
      setContentView(this.contentView);
      setWidth(-2);
      setHeight(-2);
      bgS();
    }
    paramView.post(new RedDotBubblePopupWindow.1(this, paramView));
  }
  
  public void bgT()
  {
    if (isShowing()) {
      dismiss();
    }
    if (this.mMainHandler != null) {
      this.mMainHandler.removeCallbacksAndMessages(null);
    }
    this.contentView = null;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131370713)
    {
      if (this.a != null) {
        this.a.bek();
      }
      bgT();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public static abstract interface a
  {
    public abstract void bek();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osw
 * JD-Core Version:    0.7.0.1
 */