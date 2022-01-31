import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.game.ApolloGameConfig;
import com.tencent.mobileqq.apollo.game.ApolloGameConst;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zel
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private CalloutPopupWindow jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private List jdField_a_of_type_JavaUtilList;
  private int b;
  
  public zel(Context paramContext, ApolloGameViewBinder paramApolloGameViewBinder)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramApolloGameViewBinder);
    long l = Math.min(DeviceInfoUtil.j(), DeviceInfoUtil.k());
    this.jdField_a_of_type_Int = ((int)((float)l - 30.0F * DeviceInfoUtil.a()) / 3);
    this.b = ((int)(9.0D * (this.jdField_a_of_type_Int / 16.0D)));
    QLog.i("GameListAdapter", 1, "screenWidth:" + l + ",itemWidth:" + this.jdField_a_of_type_Int + ",itemHeight:" + this.b);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow != null) {
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.dismiss();
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    int i;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      i = 0;
    }
    int k;
    int j;
    do
    {
      return i;
      k = this.jdField_a_of_type_JavaUtilList.size();
      j = k / 3;
      i = j;
    } while (k % 3 == 0);
    return j + 1;
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      localObject = null;
      return localObject;
    }
    ArrayList localArrayList = new ArrayList(3);
    int i = paramInt * 3;
    paramInt = i;
    for (;;)
    {
      localObject = localArrayList;
      if (paramInt >= i + 3) {
        break;
      }
      localObject = localArrayList;
      if (paramInt < 0) {
        break;
      }
      localObject = localArrayList;
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(paramInt));
      paramInt += 1;
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968678, paramViewGroup, false);
      paramViewGroup = new zen(null);
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[0] = ((ViewGroup)paramView.findViewById(2131363153));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[0] = ((URLImageView)paramView.findViewById(2131363154));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)paramView.findViewById(2131363156));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)paramView.findViewById(2131363155));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[0].setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
      paramViewGroup.b[0] = ((ImageView)paramView.findViewById(2131363157));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[1] = ((ViewGroup)paramView.findViewById(2131363158));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[1] = ((URLImageView)paramView.findViewById(2131363159));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)paramView.findViewById(2131363161));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)paramView.findViewById(2131363160));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[1].setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
      paramViewGroup.b[1] = ((ImageView)paramView.findViewById(2131363162));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[2] = ((ViewGroup)paramView.findViewById(2131363163));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[2] = ((URLImageView)paramView.findViewById(2131363164));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)paramView.findViewById(2131363166));
      paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[2] = ((ImageView)paramView.findViewById(2131363165));
      paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[2].setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.b));
      paramViewGroup.b[2] = ((ImageView)paramView.findViewById(2131363167));
      paramView.setTag(paramViewGroup);
      localObject1 = (ApolloGameViewBinder)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject1 == null) {
        break label1423;
      }
      ApolloGameViewBinder.a((ApolloGameViewBinder)localObject1);
    }
    label386:
    label773:
    label1293:
    label1423:
    for (Object localObject1 = ApolloGameViewBinder.a((ApolloGameViewBinder)localObject1);; localObject1 = null)
    {
      ArrayList localArrayList = (ArrayList)getItem(paramInt);
      int j;
      ApolloGameData localApolloGameData;
      Object localObject4;
      ApolloGameRedDot localApolloGameRedDot;
      Object localObject2;
      Object localObject3;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        j = 0;
        if (j >= 3) {
          break label1406;
        }
        if (j < localArrayList.size())
        {
          localApolloGameData = (ApolloGameData)localArrayList.get(j);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[j].setVisibility(0);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[j].setTag(localApolloGameData);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[j].setOnClickListener(this);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[j].setText(localApolloGameData.name);
          localObject4 = null;
          localApolloGameRedDot = null;
          if (localObject1 == null) {
            break label1414;
          }
          localObject2 = (SparseArray)((SparseArray)localObject1).get(localApolloGameData.gameId);
          if ((localObject2 == null) || (((SparseArray)localObject2).size() <= 0)) {
            break label1414;
          }
          localObject3 = (ApolloGameRedDot)((SparseArray)localObject2).get(1002);
          localObject4 = (ApolloGameRedDot)((SparseArray)localObject2).get(1001);
          localApolloGameRedDot = (ApolloGameRedDot)((SparseArray)localObject2).get(1005);
          localObject2 = (ApolloGameRedDot)((SparseArray)localObject2).get(1000);
        }
      }
      for (;;)
      {
        int i;
        if (localApolloGameData.type == 1)
        {
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j].setImageResource(2130838076);
          paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j].setVisibility(0);
          i = 0;
          label589:
          if ((localObject2 == null) || (((ApolloGameRedDot)localObject2).mIsShow)) {
            break label1411;
          }
          i = 1;
        }
        for (;;)
        {
          if (i != 0)
          {
            localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846133);
            ((Drawable)localObject2).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
            paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[j].setCompoundDrawablePadding(AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
            paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[j].setCompoundDrawables((Drawable)localObject2, null, null, null);
            label680:
            if (TextUtils.isEmpty(localApolloGameData.listCoverUrl)) {
              break label1293;
            }
            localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources();
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Resources)localObject2).getDrawable(2130838120);
            ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Resources)localObject2).getDrawable(2130838120);
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.b;
            localObject2 = URLDrawable.getDrawable(localApolloGameData.listCoverUrl, (URLDrawable.URLDrawableOptions)localObject3);
            paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[j].setImageDrawable((Drawable)localObject2);
            i = paramInt * 3 + j;
            if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (ApolloGameConfig.a("aio.city.game", ApolloGameViewBinder.a((ApolloGameViewBinder)this.jdField_a_of_type_JavaLangRefWeakReference.get())) != ApolloGameConst.d)) {
              break label1408;
            }
            i -= 1;
          }
          for (;;)
          {
            if ((i < ApolloGameUtil.a()) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (((ApolloGameViewBinder)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(localApolloGameData.gameId)) && (paramViewGroup.b[j].getVisibility() != 0))
            {
              localObject2 = paramViewGroup.b[j];
              ((ImageView)localObject2).setVisibility(0);
              localObject3 = new RedTouch(this.jdField_a_of_type_AndroidContentContext, (View)localObject2).a(19).a();
              localObject4 = new BusinessInfoCheckUpdate.RedTypeInfo();
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_type.set(4);
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_content.set("被超越");
              ((BusinessInfoCheckUpdate.RedTypeInfo)localObject4).red_desc.set("{'cn':'#FF0000', 'av':1}");
              ((RedTouch)localObject3).a((BusinessInfoCheckUpdate.RedTypeInfo)localObject4);
              ((ImageView)localObject2).setTag(localObject3);
              if (ApolloGameViewBinder.jdField_a_of_type_Long == 0L) {
                ApolloGameViewBinder.jdField_a_of_type_Long = System.currentTimeMillis();
              }
              if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
                VipUtils.a(ApolloGameViewBinder.a((ApolloGameViewBinder)this.jdField_a_of_type_JavaLangRefWeakReference.get()), "cmshow", "Apollo", "beyond_notice", 0, 0, new String[] { String.valueOf(localApolloGameData.gameId) });
              }
              if (ApolloGameViewBinder.jdField_a_of_type_Boolean)
              {
                ApolloGameViewBinder.jdField_a_of_type_Boolean = false;
                localObject3 = ApolloGameUtil.a();
                if (localObject3 != null) {
                  ((SharedPreferences)localObject3).edit().putBoolean("sp.aio.show", false).apply();
                }
                if (QLog.isColorLevel()) {
                  QLog.d("GameListAdapter", 2, "show guide window");
                }
                ((ImageView)localObject2).postDelayed(new zem(this, (ImageView)localObject2), 200L);
              }
            }
            for (;;)
            {
              j += 1;
              break label386;
              paramViewGroup = (zen)paramView.getTag();
              break;
              if ((localApolloGameRedDot != null) && (!localApolloGameRedDot.mIsShow))
              {
                i = 1;
                paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j].setImageResource(2130838080);
                paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j].setVisibility(0);
                break label589;
              }
              if (((localObject4 != null) && (!((ApolloGameRedDot)localObject4).mIsShow)) || ((localObject3 != null) && (!((ApolloGameRedDot)localObject3).mIsShow)))
              {
                i = 1;
                paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j].setImageResource(2130838048);
                paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j].setVisibility(0);
                break label589;
              }
              paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetImageView[j].setVisibility(8);
              i = 0;
              break label589;
              paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[j].setCompoundDrawablePadding(0);
              paramViewGroup.jdField_a_of_type_ArrayOfAndroidWidgetTextView[j].setCompoundDrawables(null, null, null, null);
              break label680;
              paramViewGroup.jdField_a_of_type_ArrayOfComTencentImageURLImageView[j].setImageResource(2130838120);
              break label773;
              if ((paramViewGroup.b[j].getTag() != null) && ((paramViewGroup.b[j].getTag() instanceof RedTouch))) {
                ((RedTouch)paramViewGroup.b[j].getTag()).b();
              }
              paramViewGroup.b[j].setVisibility(4);
              continue;
              paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[j].setVisibility(4);
            }
            paramInt = 0;
            while (paramInt < 3)
            {
              paramViewGroup.jdField_a_of_type_ArrayOfAndroidViewViewGroup[paramInt].setVisibility(4);
              paramInt += 1;
            }
            label1406:
            return paramView;
          }
        }
        localObject2 = null;
        localObject3 = null;
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    ApolloGameData localApolloGameData = (ApolloGameData)paramView.getTag();
    if (localApolloGameData == null)
    {
      QLog.e("GameListAdapter", 1, "[onClick] no game data");
      return;
    }
    ApolloGameViewBinder localApolloGameViewBinder = (ApolloGameViewBinder)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localApolloGameViewBinder != null) {
      if (ApolloGameViewBinder.a(localApolloGameViewBinder) != null) {
        if (paramView.getId() == 2131363153) {
          paramView = paramView.findViewById(2131363157);
        }
      }
    }
    for (;;)
    {
      if ((paramView != null) && (paramView.getVisibility() == 0))
      {
        paramView.setVisibility(8);
        if ((paramView.getTag() != null) && ((paramView.getTag() instanceof RedTouch))) {
          ((RedTouch)paramView.getTag()).b();
        }
        VipUtils.a(ApolloGameViewBinder.a((ApolloGameViewBinder)this.jdField_a_of_type_JavaLangRefWeakReference.get()), "cmshow", "Apollo", "beyond_notice_disappear", 1, 0, new String[] { String.valueOf(localApolloGameData.gameId) });
      }
      paramView = ApolloGameViewBinder.a(localApolloGameViewBinder);
      label218:
      Object localObject;
      if ((paramView != null) && (paramView.size() > 0))
      {
        Iterator localIterator = paramView.iterator();
        paramView = null;
        if (localIterator.hasNext())
        {
          localObject = (ApolloGameRankData)localIterator.next();
          if ((localObject == null) || (((ApolloGameRankData)localObject).mGameId != localApolloGameData.gameId)) {
            break label397;
          }
          paramView = (View)localObject;
        }
      }
      label397:
      for (;;)
      {
        break label218;
        if (paramView.getId() == 2131363158)
        {
          paramView = paramView.findViewById(2131363162);
          break;
        }
        if (paramView.getId() != 2131363163) {
          break label400;
        }
        paramView = paramView.findViewById(2131363167);
        break;
        localObject = ApolloGameViewBinder.a(localApolloGameViewBinder);
        if (paramView != null) {}
        try
        {
          paramView.mValidTime = (System.currentTimeMillis() - 1000L);
          ApolloGameUtil.a(ApolloGameViewBinder.a(localApolloGameViewBinder), paramView);
          ApolloGameViewBinder.a(localApolloGameViewBinder).remove(paramView);
          if (QLog.isColorLevel()) {
            QLog.d("GameListAdapter", 2, new Object[] { "[onClick] remove red corner for ", Integer.valueOf(localApolloGameData.gameId) });
          }
          ApolloGameViewBinder.a(localApolloGameViewBinder, localApolloGameData);
          return;
        }
        finally {}
        QLog.e("GameListAdapter", 1, "[onClick] binder null");
        return;
      }
      label400:
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     zel
 * JD-Core Version:    0.7.0.1
 */