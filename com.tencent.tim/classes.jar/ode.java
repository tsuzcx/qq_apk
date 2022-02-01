import android.app.Activity;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RangeButtonView.a;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Deprecated
public class ode
  implements Handler.Callback, AdapterView.OnItemClickListener
{
  public ShareActionSheetBuilder a;
  private ncy jdField_a_of_type_Ncy;
  private ode.a jdField_a_of_type_Ode$a;
  private ode.b jdField_a_of_type_Ode$b;
  protected ode.c a;
  private oee jdField_a_of_type_Oee;
  private auru jdField_b_of_type_Auru;
  private RangeButtonView.a jdField_b_of_type_ComTencentWidgetRangeButtonView$a = new odf(this);
  private int bet = -1;
  public Activity s;
  
  private boolean a(ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList, int paramInt, ode.e parame)
  {
    if (parame != null)
    {
      parame = parame.a(Integer.valueOf(paramInt));
      if (parame != null)
      {
        paramArrayList.add(parame);
        return true;
      }
    }
    return false;
  }
  
  public void a(ode.a parama)
  {
    this.jdField_a_of_type_Ode$a = parama;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a(List<Integer>[] paramArrayOfList, ode.e parame)
  {
    ArrayList localArrayList1 = new ArrayList();
    int j = paramArrayOfList.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfList[i];
      ArrayList localArrayList2 = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(localArrayList2, ((Integer)((Iterator)localObject).next()).intValue(), parame);
      }
      localArrayList1.add(localArrayList2);
      i += 1;
    }
    return (List[])localArrayList1.toArray(new ArrayList[localArrayList1.size()]);
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (paramMessage.obj != null) {
        pn((String)paramMessage.obj);
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Oee != null) {
      this.jdField_a_of_type_Oee.onDestroy();
    }
    if (this.jdField_a_of_type_Ncy != null) {
      this.jdField_a_of_type_Ncy.onDestroy();
    }
    this.jdField_b_of_type_Auru.removeCallbacksAndMessages(null);
    dismiss();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onItemClick, tag = ");
      if (localObject != null)
      {
        bool = true;
        QLog.d("ReadInJoyShareHelper", 2, bool);
      }
    }
    else
    {
      if (localObject != null) {
        break label73;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      bool = false;
      break;
      label73:
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
      localObject = (ode.d)((ShareActionSheetBuilder.b)localObject).b;
      int i = ((ode.d)localObject).action;
      if (this.jdField_a_of_type_Ode$a != null) {
        if (((ode.d)localObject).aww)
        {
          this.jdField_a_of_type_Ode$a.c(Integer.valueOf(i));
        }
        else
        {
          localObject = this.jdField_a_of_type_Ode$c.d(i);
          if (localObject != null) {
            this.jdField_a_of_type_Ode$a.c((Integer)localObject);
          }
        }
      }
    }
  }
  
  public void pn(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      rwt.ez(1, 2131697457);
      return;
    }
    paramString = EditPicActivity.a(this.s, paramString, true, true, true, true, true, 4);
    this.s.startActivity(paramString);
  }
  
  public static class a
  {
    protected boolean c(Integer paramInteger)
    {
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract void i(int paramInt, float paramFloat);
  }
  
  public static class c
    implements ode.e
  {
    protected Map<Integer, Integer> eY = new HashMap();
    protected Map<Integer, Integer> eZ = new HashMap();
    
    public c()
    {
      bdD();
    }
    
    public ShareActionSheetBuilder.ActionSheetItem a(Integer paramInteger)
    {
      Object localObject = null;
      if (BaseApplicationImpl.getApplication().getRuntime() != null) {
        localObject = BaseApplicationImpl.getApplication().getRuntime();
      }
      if ((paramInteger == null) || (localObject == null)) {
        localObject = null;
      }
      ode.d locald;
      do
      {
        return localObject;
        locald = new ode.d();
        if (paramInteger.intValue() == 1)
        {
          locald.label = BaseApplicationImpl.getApplication().getString(2131698635);
          locald.icon = 2130843490;
          locald.iconNeedBg = true;
          locald.action = dH(paramInteger.intValue());
          locald.argus = "";
          return locald;
        }
        if (paramInteger.intValue() == 2)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131698630);
          ((ode.d)localObject).icon = 2130839252;
          ((ode.d)localObject).iconNeedBg = true;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 3)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131698643);
          ((ode.d)localObject).icon = 2130839253;
          ((ode.d)localObject).iconNeedBg = true;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 4)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131698652);
          ((ode.d)localObject).icon = 2130839256;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 5)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131698633);
          ((ode.d)localObject).icon = 2130839249;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 6)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131698647);
          ((ode.d)localObject).iconNeedBg = true;
          ((ode.d)localObject).icon = 2130839255;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 7)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131698626);
          ((ode.d)localObject).icon = 2130843493;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 8)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131698627);
          ((ode.d)localObject).iconNeedBg = true;
          ((ode.d)localObject).icon = 2130843489;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 9)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131698656);
          ((ode.d)localObject).iconNeedBg = true;
          ((ode.d)localObject).icon = 2130843494;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 10)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131698625);
          ((ode.d)localObject).icon = 2130843491;
          ((ode.d)localObject).iconNeedBg = true;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 12)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131698616);
          ((ode.d)localObject).iconNeedBg = true;
          ((ode.d)localObject).icon = 2130842496;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 39)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131720087);
          ((ode.d)localObject).iconNeedBg = true;
          ((ode.d)localObject).icon = 2130845059;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 28)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131698624);
          ((ode.d)localObject).iconNeedBg = true;
          ((ode.d)localObject).icon = 2130851586;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 13)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131698638);
          ((ode.d)localObject).icon = 2130839582;
          ((ode.d)localObject).iconNeedBg = true;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 14)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131698622);
          ((ode.d)localObject).icon = 2130839246;
          ((ode.d)localObject).iconNeedBg = true;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 20)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131698628);
          ((ode.d)localObject).icon = 2130843479;
          ((ode.d)localObject).iconNeedBg = true;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 15)
        {
          localObject = new ode.d();
          ((ode.d)localObject).label = BaseApplicationImpl.getApplication().getString(2131698623);
          ((ode.d)localObject).iconNeedBg = true;
          ((ode.d)localObject).icon = 2130843478;
          ((ode.d)localObject).action = dH(paramInteger.intValue());
          ((ode.d)localObject).argus = "";
          return localObject;
        }
        if (paramInteger.intValue() == 11)
        {
          locald.label = BaseApplicationImpl.getApplication().getString(2131698645);
          locald.icon = 2130839254;
          locald.iconNeedBg = true;
          locald.action = dH(paramInteger.intValue());
          locald.argus = "";
          return locald;
        }
        if (paramInteger.intValue() == 19)
        {
          locald.label = BaseApplicationImpl.getApplication().getString(2131698637);
          locald.icon = 2130843492;
          locald.iconNeedBg = true;
          locald.action = dH(paramInteger.intValue());
          locald.argus = "";
          return locald;
        }
        if (paramInteger.intValue() == 17)
        {
          locald.label = BaseApplicationImpl.getApplication().getString(2131698631);
          locald.icon = 2130843496;
          locald.iconNeedBg = true;
          locald.action = dH(paramInteger.intValue());
          locald.argus = "";
          return locald;
        }
        if (paramInteger.intValue() == 16)
        {
          locald.label = BaseApplicationImpl.getApplication().getString(2131697409);
          locald.icon = 2130843495;
          locald.iconNeedBg = true;
          locald.action = dH(paramInteger.intValue());
          locald.argus = "";
          return locald;
        }
        if (paramInteger.intValue() == 21)
        {
          locald.label = BaseApplicationImpl.getApplication().getString(2131697470);
          locald.icon = 2130843487;
          locald.iconNeedBg = true;
          locald.action = dH(paramInteger.intValue());
          locald.argus = "";
          return locald;
        }
        if (paramInteger.intValue() == 18)
        {
          locald.icon = 2130843488;
          locald.iconNeedBg = true;
          locald.action = 18;
          locald.aww = true;
          locald.argus = "";
          return locald;
        }
        if (paramInteger.intValue() == 22)
        {
          locald.label = BaseApplicationImpl.getApplication().getString(2131698639);
          locald.icon = 2130843498;
          locald.iconNeedBg = true;
          locald.action = 22;
          locald.aww = true;
          locald.argus = "";
          return locald;
        }
        if (paramInteger.intValue() == 23)
        {
          locald.label = BaseApplicationImpl.getApplication().getString(2131698651);
          locald.icon = 2130843506;
          locald.iconNeedBg = true;
          locald.action = 23;
          locald.aww = true;
          locald.argus = "";
          return locald;
        }
        if (paramInteger.intValue() == 25)
        {
          locald.iconNeedBg = true;
          locald.icon = 2130839149;
          locald.action = 25;
          locald.argus = "";
          locald.aww = true;
          return locald;
        }
        if (paramInteger.intValue() == 26)
        {
          locald.iconNeedBg = true;
          locald.icon = 2130839153;
          locald.action = 26;
          locald.argus = "";
          locald.aww = true;
          return locald;
        }
        if (paramInteger.intValue() == 27)
        {
          locald.iconNeedBg = true;
          locald.icon = 2130839151;
          locald.action = 27;
          locald.argus = "";
          locald.aww = true;
          return locald;
        }
        if (paramInteger.intValue() == 29)
        {
          locald.label = BaseApplicationImpl.getApplication().getString(2131691354);
          locald.iconNeedBg = true;
          locald.icon = 2130839174;
          locald.action = 29;
          locald.argus = "";
          locald.aww = true;
          return locald;
        }
        if (paramInteger.intValue() == 30)
        {
          locald.label = BaseApplicationImpl.getApplication().getString(2131691352);
          locald.iconNeedBg = true;
          locald.icon = 2130839148;
          locald.action = 30;
          locald.argus = "";
          locald.aww = true;
          return locald;
        }
        if (paramInteger.intValue() == 31)
        {
          locald.label = BaseApplicationImpl.getApplication().getString(2131691355);
          locald.iconNeedBg = true;
          locald.icon = 2130839152;
          locald.action = 31;
          locald.argus = "";
          locald.aww = true;
          return locald;
        }
        if (paramInteger.intValue() == 32)
        {
          locald.label = BaseApplicationImpl.getApplication().getString(2131691718);
          locald.iconNeedBg = true;
          locald.icon = 2130843164;
          locald.action = 32;
          locald.argus = "";
          locald.aww = true;
          return locald;
        }
        if (paramInteger.intValue() == 33)
        {
          locald.label = BaseApplicationImpl.getApplication().getString(2131691721);
          locald.iconNeedBg = true;
          locald.icon = 2130843165;
          locald.action = 33;
          locald.argus = "";
          locald.aww = true;
          return locald;
        }
        if (paramInteger.intValue() == 34)
        {
          locald.label = BaseApplicationImpl.getApplication().getString(2131691356);
          locald.iconNeedBg = true;
          locald.icon = 2130839183;
          locald.action = 34;
          locald.argus = "";
          locald.aww = true;
          return locald;
        }
        localObject = locald;
      } while (paramInteger.intValue() != 35);
      locald.label = BaseApplicationImpl.getApplication().getString(2131691353);
      locald.iconNeedBg = true;
      locald.icon = 2130839150;
      locald.action = 35;
      locald.argus = "";
      locald.aww = true;
      return locald;
    }
    
    protected void bdD()
    {
      this.eY.put(Integer.valueOf(34), Integer.valueOf(1));
      this.eY.put(Integer.valueOf(2), Integer.valueOf(2));
      this.eY.put(Integer.valueOf(3), Integer.valueOf(3));
      this.eY.put(Integer.valueOf(9), Integer.valueOf(4));
      this.eY.put(Integer.valueOf(10), Integer.valueOf(5));
      this.eY.put(Integer.valueOf(12), Integer.valueOf(6));
      this.eY.put(Integer.valueOf(5), Integer.valueOf(7));
      this.eY.put(Integer.valueOf(4), Integer.valueOf(8));
      this.eY.put(Integer.valueOf(21), Integer.valueOf(9));
      this.eY.put(Integer.valueOf(7), Integer.valueOf(10));
      this.eY.put(Integer.valueOf(6), Integer.valueOf(12));
      this.eY.put(Integer.valueOf(129), Integer.valueOf(39));
      this.eY.put(Integer.valueOf(26), Integer.valueOf(13));
      this.eY.put(Integer.valueOf(1), Integer.valueOf(14));
      this.eY.put(Integer.valueOf(11), Integer.valueOf(20));
      this.eY.put(Integer.valueOf(44), Integer.valueOf(15));
      this.eY.put(Integer.valueOf(43), Integer.valueOf(11));
      this.eY.put(Integer.valueOf(38), Integer.valueOf(19));
      this.eY.put(Integer.valueOf(35), Integer.valueOf(17));
      this.eY.put(Integer.valueOf(37), Integer.valueOf(16));
      this.eY.put(Integer.valueOf(31), Integer.valueOf(21));
      this.eY.put(Integer.valueOf(40), Integer.valueOf(25));
      this.eY.put(Integer.valueOf(68), Integer.valueOf(28));
      this.eY.put(Integer.valueOf(129), Integer.valueOf(39));
      Iterator localIterator = this.eY.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        this.eZ.put(localEntry.getValue(), localEntry.getKey());
      }
    }
    
    protected Integer d(int paramInt)
    {
      return (Integer)this.eY.get(Integer.valueOf(paramInt));
    }
    
    protected int dH(int paramInt)
    {
      return ((Integer)this.eZ.get(Integer.valueOf(paramInt))).intValue();
    }
  }
  
  public static class d
    extends ShareActionSheetBuilder.ActionSheetItem
  {
    public boolean aww;
  }
  
  static abstract interface e
  {
    public abstract ShareActionSheetBuilder.ActionSheetItem a(Integer paramInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ode
 * JD-Core Version:    0.7.0.1
 */