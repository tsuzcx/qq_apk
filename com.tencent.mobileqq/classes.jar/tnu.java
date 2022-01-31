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
import java.util.ArrayList;
import java.util.ArrayList<LUserGrowth.stNotificationRedDot;>;
import java.util.Iterator;

public class tnu
  extends PopupWindow
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = bdkf.a(8.0F);
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private tnv jdField_a_of_type_Tnv;
  private TextView b;
  private TextView c;
  
  public tnu(Context paramContext, tnv paramtnv)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Tnv = paramtnv;
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
      j = jdField_a_of_type_Int;
      break label66;
      return;
    }
  }
  
  private void b(View paramView, ArrayList<stNotificationRedDot> paramArrayList)
  {
    paramView.findViewById(2131369677).setOnClickListener(this);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView.findViewById(2131369415));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView.findViewById(2131365991));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramView.findViewById(2131371461));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369422));
    this.b = ((TextView)paramView.findViewById(2131365994));
    this.c = ((TextView)paramView.findViewById(2131371462));
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
          ((View)this.jdField_a_of_type_JavaUtilArrayList.get(0)).setVisibility(8);
          if (!TextUtils.isEmpty(localObject3)) {
            break label344;
          }
          ((View)this.jdField_a_of_type_JavaUtilArrayList.get(1)).setVisibility(8);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label371;
          }
          ((View)this.jdField_a_of_type_JavaUtilArrayList.get(2)).setVisibility(8);
          return;
          ((View)this.jdField_a_of_type_JavaUtilArrayList.get(0)).setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject4);
          break;
          label344:
          ((View)this.jdField_a_of_type_JavaUtilArrayList.get(1)).setVisibility(0);
          this.b.setText(localObject3);
        }
        label371:
        ((View)this.jdField_a_of_type_JavaUtilArrayList.get(2)).setVisibility(0);
        this.c.setText((CharSequence)localObject2);
      }
      else
      {
        localObject2 = paramArrayList;
        paramArrayList = (ArrayList<stNotificationRedDot>)localObject1;
        localObject1 = localObject2;
      }
    }
  }
  
  public void a()
  {
    if (isShowing()) {
      dismiss();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void a(View paramView, ArrayList<stNotificationRedDot> paramArrayList)
  {
    if (isShowing()) {
      dismiss();
    }
    if (paramView == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      setBackgroundDrawable(new BitmapDrawable());
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559850, null);
      b(this.jdField_a_of_type_AndroidViewView, paramArrayList);
      setContentView(this.jdField_a_of_type_AndroidViewView);
      setWidth(-2);
      setHeight(-2);
      b();
    }
    paramView.post(new RedDotBubblePopupWindow.1(this, paramView));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369677)
    {
      if (this.jdField_a_of_type_Tnv != null) {
        this.jdField_a_of_type_Tnv.a();
      }
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tnu
 * JD-Core Version:    0.7.0.1
 */