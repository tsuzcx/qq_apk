import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class atdp
  extends aakb
  implements View.OnTouchListener
{
  private int mType = 0;
  private List<String> vo;
  
  public atdp() {}
  
  public atdp(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    paramc = null;
    paramViewGroup = paramc;
    if (paramView != null)
    {
      paramViewGroup = paramc;
      if ((paramView.getTag() instanceof atdp.a)) {
        paramViewGroup = (atdp.a)paramView.getTag();
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new atdp.a();
      paramView = a(paramContext, 2131561288, paramViewGroup);
      paramView.findViewById(2131379403).setPadding(0, 0, paramContext.getResources().getDisplayMetrics().widthPixels * 25 / 360, 0);
      paramViewGroup.a = ((ShaderAnimLayout)paramView.findViewById(2131378161));
      paramViewGroup.icon = ((ImageView)paramView.findViewById(2131368698));
      paramViewGroup.aez = ((TextView)paramView.findViewById(2131368749));
      paramViewGroup.aeB = ((TextView)paramView.findViewById(2131378901));
      paramViewGroup.title = ((TextView)paramView.findViewById(2131379402));
      paramViewGroup.title.setMaxWidth(paramContext.getResources().getDisplayMetrics().widthPixels * 145 / 360);
      paramViewGroup.GS = ((ImageView)paramView.findViewById(2131364183));
      paramViewGroup.aeA = ((TextView)paramView.findViewById(2131379406));
      paramViewGroup.content = ((TextView)paramView.findViewById(16908309));
      paramViewGroup.GT = ((ImageView)paramView.findViewById(2131364182));
      paramViewGroup.aeC = ((TextView)paramView.findViewById(2131364185));
      paramViewGroup.GU = ((ImageView)paramView.findViewById(2131370426));
      paramViewGroup.wT = ((ImageView)paramView.findViewById(2131372279));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack) {
        paramView.setContentDescription(null);
      }
      if ((paramObject instanceof RecentBaseData))
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
        paramc = null;
        if (paramaajx != null)
        {
          if ((this.c.getStyle() == 4) && ((localRecentBaseData instanceof RecentCallItem)) && (localRecentBaseData.ng() == 3000)) {
            ((RecentCallItem)localRecentBaseData).isPstnDiscussionCall = true;
          }
          paramc = paramaajx.a(localRecentBaseData);
        }
        a(paramView, localRecentBaseData, paramContext, paramc);
      }
      for (;;)
      {
        a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramViewGroup.GT.setOnClickListener(paramOnClickListener);
        paramViewGroup.GT.setOnTouchListener(this);
        paramViewGroup.GT.setTag(-1, Integer.valueOf(paramInt));
        paramViewGroup.wT.setOnClickListener(paramOnClickListener);
        paramViewGroup.wT.setOnLongClickListener(paramOnLongClickListener);
        paramViewGroup.wT.setTag(-1, Integer.valueOf(paramInt));
        paramViewGroup.wT.setTag(paramView);
        paramViewGroup.wT.setOnTouchListener(new atdq(this));
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        paramViewGroup.a.setVisibility(8);
        paramViewGroup.title.setText("");
        paramViewGroup.aeB.setText("");
        paramViewGroup.aeA.setVisibility(8);
        paramViewGroup.content.setText("");
        paramViewGroup.GS.setVisibility(8);
        paramViewGroup.wT.setVisibility(8);
      }
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    paramRecentBaseData = paramContext.getResources();
    if (this.vo == null) {
      this.vo = new ArrayList();
    }
    for (;;)
    {
      this.vo.add(paramRecentBaseData.getString(2131692505));
      return this.vo;
      this.vo.clear();
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    Object localObject1 = paramView.getTag();
    if ((localObject1 instanceof atdp.a)) {}
    for (atdp.a locala = (atdp.a)localObject1;; locala = null)
    {
      if (locala == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject1);
        return;
      }
      locala.icon.setImageDrawable(paramDrawable);
      int m = paramRecentBaseData.mAuthenIconId;
      RecentCallItem localRecentCallItem = (RecentCallItem)paramRecentBaseData;
      long l = localRecentCallItem.mCallMemberNum;
      if (QLog.isColorLevel()) {
        QLog.d("RecentCallItemBuilder", 2, "zswzsw number = " + l);
      }
      Object localObject2 = localRecentCallItem.a();
      label270:
      int j;
      int i;
      if ((((QCallRecent)localObject2).type == 56938) || (((QCallRecent)localObject2).type == 3) || (((QCallRecent)localObject2).type == 4) || (((QCallRecent)localObject2).type == 2016) || ((((QCallRecent)localObject2).type == 26) && (!aljw.O(this.c.app, ((QCallRecent)localObject2).uin))))
      {
        locala.icon.setImageResource(2130842937);
        if (locala.aez != null)
        {
          locala.aez.setVisibility(0);
          if (paramRecentBaseData.mTitleName != null) {
            locala.aez.setText(aqgv.pu(paramRecentBaseData.mTitleName));
          }
        }
        if (m != 0) {
          break label1158;
        }
        j = paramRecentBaseData.mUnreadNum;
        i = 2130845947;
      }
      label1413:
      for (;;)
      {
        label286:
        int k = i;
        if (l > 0L)
        {
          k = i;
          if (m != 3) {
            k = 2130845949;
          }
        }
        if (m == 6)
        {
          k = 2130845949;
          label324:
          if (k != 0) {
            break label1236;
          }
          locala.GS.setVisibility(8);
          label339:
          if (m != 0) {
            break label1258;
          }
          i = 2131167441;
          label349:
          paramDrawable = paramRecentBaseData.mTitleName;
          if ((!(paramRecentBaseData instanceof RecentCallItem)) || (!((RecentCallItem)paramRecentBaseData).WD())) {
            break label1727;
          }
          paramDrawable = aqgv.w(this.c.app, paramRecentBaseData.qx());
        }
        label520:
        label823:
        label1465:
        label1727:
        for (;;)
        {
          localObject1 = locala.title.getText();
          if (paramDrawable == null) {
            paramDrawable = "";
          }
          for (;;)
          {
            k = 0;
            if ((locala.title.getTag() instanceof Integer)) {
              k = ((Integer)locala.title.getTag()).intValue();
            }
            if (k != i)
            {
              locala.title.setTextColor(paramContext.getResources().getColorStateList(i));
              locala.title.setTag(Integer.valueOf(i));
            }
            if (!paramDrawable.equals(localObject1)) {
              locala.title.setText(paramDrawable);
            }
            if ((m == 0) && (j >= 2)) {
              if (j > 99)
              {
                paramDrawable = " [99+]";
                if (!paramDrawable.equals(locala.aeB.getText())) {
                  locala.aeB.setText(paramDrawable);
                }
                localObject1 = null;
                i = paramRecentBaseData.mMenuFlag & 0xF000;
                if ((i != 12288) || (((QCallRecent)localObject2).isSystemCall == 1)) {
                  break label1305;
                }
                if (locala.aeA.getVisibility() != 0) {
                  locala.aeA.setVisibility(0);
                }
                paramDrawable = paramContext.getString(2131700835);
                label605:
                CharSequence localCharSequence = locala.aeA.getText();
                localObject1 = paramDrawable;
                if (paramDrawable == null) {
                  localObject1 = "";
                }
                if (!localObject1.equals(localCharSequence)) {
                  locala.aeA.setText((CharSequence)localObject1);
                }
                if ((paramRecentBaseData.mAuthenIconId == 3) || (l > 0L) || (paramRecentBaseData.mAuthenIconId == 4) || (paramRecentBaseData.mAuthenIconId == 5) || (paramRecentBaseData.mAuthenIconId == 6) || (paramRecentBaseData.mAuthenIconId == 7))
                {
                  if (TextUtils.isEmpty(paramRecentBaseData.mCallingText)) {
                    break label1413;
                  }
                  locala.aeA.setText(paramRecentBaseData.mCallingText);
                  locala.aeA.setVisibility(0);
                }
                label728:
                if (QLog.isColorLevel()) {
                  QLog.d("RecentCallItemBuilder", 2, "call.callType = " + ((QCallRecent)localObject2).callType + ", isVideo : " + ((QCallRecent)localObject2).isVideo());
                }
                locala.aeC.setVisibility(8);
                if (!((QCallRecent)localObject2).isVideo()) {
                  break label1436;
                }
                locala.GT.setImageResource(2130846663);
                locala.GT.setContentDescription(paramContext.getString(2131697604));
                if ((paramRecentBaseData.mAuthenIconId != 3) && (l <= 0L)) {
                  break label1465;
                }
                paramDrawable = paramContext.getString(2131700805);
                locala.GU.setVisibility(8);
                label857:
                if (((QCallRecent)localObject2).isSystemCall != 1) {
                  break label1657;
                }
                locala.GT.setImageResource(2130847103);
              }
            }
            try
            {
              label877:
              localObject1 = locala.aeA.getText().toString();
              if ((localObject1 == null) || ("".equals(localObject1))) {
                locala.aeA.setVisibility(8);
              }
            }
            catch (Exception localException)
            {
              break label917;
            }
            if (QLog.isColorLevel()) {
              QLog.d("RecentCallItemBuilder", 2, "item.mAuthenIconId：" + paramRecentBaseData.mAuthenIconId + ", item.mTitleName:" + paramRecentBaseData.mTitleName);
            }
            localObject1 = paramDrawable;
            if (((QCallRecent)localObject2).isSystemCall == 1)
            {
              if (((QCallRecent)localObject2).type != 26) {
                break label1681;
              }
              locala.GU.setVisibility(8);
              localObject1 = paramDrawable;
              if (paramDrawable.equals(paramContext.getString(2131700809))) {}
            }
            for (localObject1 = paramContext.getString(2131700830) + " " + paramDrawable;; localObject1 = paramContext.getString(2131700831) + " " + paramRecentBaseData.mShowTime)
            {
              localObject2 = locala.content.getText();
              paramDrawable = (Drawable)localObject1;
              if (localObject1 == null) {
                paramDrawable = "";
              }
              if (!paramDrawable.equals(localObject2)) {
                locala.content.setText(paramDrawable);
              }
              a(locala, paramRecentBaseData, paramContext);
              locala.a.setVisibility(8);
              if (!AppSetting.enableTalkBack) {
                break;
              }
              paramView.setContentDescription(paramRecentBaseData.mContentDesc);
              return;
              locala.icon.setImageDrawable(paramDrawable);
              if (locala.aez == null) {
                break label270;
              }
              locala.aez.setVisibility(8);
              break label270;
              if (m <= 1)
              {
                j = 0;
                i = 2130845936;
                break label286;
              }
              if (m <= 2)
              {
                j = 0;
                i = 2130845941;
                break label286;
              }
              if (m > 3) {
                break label1730;
              }
              j = 0;
              i = 2130845939;
              break label286;
              if ((m != 5) && (m != 4) && (m != 7)) {
                break label324;
              }
              k = 2130845939;
              break label324;
              label1236:
              locala.GS.setVisibility(0);
              locala.GS.setImageResource(k);
              break label339;
              label1258:
              i = 2131167311;
              break label349;
              paramDrawable = " [" + j + "]";
              break label520;
              paramDrawable = "";
              break label520;
              if ((i == 16384) && (((QCallRecent)localObject2).isSystemCall != 1))
              {
                paramDrawable = (Drawable)localObject1;
                if (!QLog.isColorLevel()) {
                  break label605;
                }
                QLog.d("RecentCallItemBuilder", 2, "type = " + i + ", isVideo : " + ((QCallRecent)localObject2).isVideo());
                paramDrawable = (Drawable)localObject1;
                break label605;
              }
              paramDrawable = (Drawable)localObject1;
              if (locala.aeA.getVisibility() != 0) {
                break label605;
              }
              locala.aeA.setVisibility(8);
              paramDrawable = (Drawable)localObject1;
              break label605;
              locala.aeA.setText("");
              locala.aeA.setVisibility(8);
              break label728;
              locala.GT.setImageResource(2130843076);
              locala.GT.setContentDescription(paramContext.getString(2131697602));
              break label823;
              if (paramRecentBaseData.mAuthenIconId == 4)
              {
                paramDrawable = paramContext.getString(2131700808);
                locala.GU.setVisibility(8);
                break label857;
              }
              if (paramRecentBaseData.mAuthenIconId == 5)
              {
                paramDrawable = paramContext.getString(2131700809);
                locala.GU.setVisibility(8);
                break label857;
              }
              if (paramRecentBaseData.mAuthenIconId == 6)
              {
                paramDrawable = paramContext.getString(2131700810);
                locala.GU.setVisibility(8);
                break label857;
              }
              if (((QCallRecent)localObject2).type == 8)
              {
                locala.GU.setVisibility(0);
                paramDrawable = paramRecentBaseData.mShowTime;
                break label857;
              }
              if (((QCallRecent)localObject2).type == 26)
              {
                locala.GU.setVisibility(0);
                paramDrawable = aljw.mN(((QCallRecent)localObject2).uin);
                if (!paramDrawable.equals(localRecentCallItem.mTitleName)) {
                  break label857;
                }
                paramDrawable = paramRecentBaseData.mShowTime;
                break label857;
              }
              paramDrawable = paramRecentBaseData.mShowTime;
              locala.GU.setVisibility(8);
              break label857;
              label1657:
              if (((QCallRecent)localObject2).type != 26) {
                break label877;
              }
              locala.GT.setImageResource(2130847103);
              break label877;
            }
          }
        }
        label917:
        label1305:
        label1436:
        label1730:
        j = 0;
        label1158:
        label1681:
        i = 0;
      }
    }
  }
  
  protected void a(atdp.a parama, RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((parama == null) || (paramRecentBaseData == null)) {
      return;
    }
    if (paramRecentBaseData.mOnlineStatus == 0)
    {
      parama.wT.setVisibility(8);
      return;
    }
    int i;
    switch (paramRecentBaseData.mStatus)
    {
    default: 
      i = 0;
      label63:
      aqcl.io(parama.wT);
      if (i == 0) {
        parama.wT.setVisibility(8);
      }
      break;
    }
    for (;;)
    {
      if (this.mType == 1) {
        parama.wT.setVisibility(8);
      }
      if (!(paramRecentBaseData instanceof RecentCallItem)) {
        break;
      }
      paramContext = (atdc)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(746);
      if ((paramContext == null) || (paramContext.Og() != 1)) {
        break;
      }
      paramRecentBaseData = ((RecentCallItem)paramRecentBaseData).a();
      if ((paramRecentBaseData == null) || ((paramRecentBaseData.callType != 2) && (paramRecentBaseData.type != 26))) {
        break;
      }
      parama.wT.setVisibility(8);
      return;
      i = 2130845926;
      break label63;
      i = 2130845928;
      break label63;
      i = 2130845932;
      break label63;
      i = 2130845924;
      break label63;
      parama.wT.setVisibility(0);
      parama.wT.setImageResource(i);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return true;
    case 0: 
      paramView.setDuplicateParentStateEnabled(false);
      paramView.setPressed(true);
      return true;
    }
    paramView.setDuplicateParentStateEnabled(true);
    paramView.setPressed(false);
    return true;
  }
  
  public static class a
    extends aakb.a
  {
    public ImageView GS;
    public ImageView GT;
    public ImageView GU;
    public ShaderAnimLayout a;
    public TextView aeA;
    public TextView aeB;
    public TextView aeC;
    public TextView aez;
    public TextView content;
    public ImageView icon;
    public TextView title;
    public ImageView wT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdp
 * JD-Core Version:    0.7.0.1
 */