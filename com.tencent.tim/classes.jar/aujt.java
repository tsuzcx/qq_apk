import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.graphics.Rect;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.resourcesgrab.ResourceGrabFragment;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class aujt
  implements View.OnClickListener
{
  private List<aujl> KZ;
  boolean dja;
  View.OnClickListener gE;
  
  aujt(List<aujl> paramList, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    this.KZ = paramList;
    this.gE = paramOnClickListener;
    this.dja = paramBoolean;
  }
  
  private List<aujl> a(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject = View.class.getDeclaredMethod("getListenerInfo", new Class[0]);
      if (!((Method)localObject).isAccessible()) {
        ((Method)localObject).setAccessible(true);
      }
      paramView = ((Method)localObject).invoke(paramView, new Object[0]);
      localObject = paramView.getClass().getDeclaredField("mOnClickListener");
      ((Field)localObject).setAccessible(true);
      paramView = (View.OnClickListener)((Field)localObject).get(paramView);
      if ((paramView instanceof aujt))
      {
        paramView = ((aujt)paramView).KZ;
        if ((paramView != null) && (paramView.size() > 0)) {
          localArrayList.addAll(paramView);
        }
      }
      return localArrayList;
    }
    catch (Exception paramView)
    {
      QLog.d("ResourceNameOnClickListener", 1, paramView, new Object[0]);
    }
    return localArrayList;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceNameOnClickListener", 2, "ResourceNameOnClickListener onLongClick");
    }
    Object localObject1 = null;
    if ((paramView.getContext() instanceof Activity)) {
      localObject1 = (Activity)paramView.getContext();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = BaseActivity.sTopActivity;
    }
    if ((localObject2 instanceof FragmentActivity))
    {
      localObject1 = ((FragmentActivity)localObject2).getSupportFragmentManager().findFragmentByTag("ResourceGrabFragment");
      if ((localObject1 instanceof ResourceGrabFragment))
      {
        localObject1 = (ResourceGrabFragment)localObject1;
        aujo localaujo = (aujo)ajos.a((ViewModelStoreOwner)localObject1).get(aujo.class);
        ArrayList localArrayList = new ArrayList(this.KZ);
        try
        {
          if ((paramView instanceof ViewGroup))
          {
            Rect localRect = new Rect();
            int i = 0;
            while (i < ((ViewGroup)paramView).getChildCount())
            {
              Object localObject3 = ((ViewGroup)paramView).getChildAt(i);
              ((View)localObject3).getGlobalVisibleRect(localRect);
              if (localRect.contains(((FragmentActivity)localObject2).clickX, ((FragmentActivity)localObject2).clickY))
              {
                localObject3 = a((View)localObject3);
                if (((List)localObject3).size() > 0) {
                  localArrayList.addAll((Collection)localObject3);
                }
              }
              i += 1;
            }
          }
          EventCollector.getInstance().onViewClicked(paramView);
        }
        catch (Exception localException)
        {
          QLog.d("ResourceNameOnClickListener", 1, localException, new Object[0]);
          ((ResourceGrabFragment)localObject1).nW(localArrayList);
          if (((ResourceGrabFragment)localObject1).aJt()) {
            localaujo.nX(localArrayList);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aujt
 * JD-Core Version:    0.7.0.1
 */