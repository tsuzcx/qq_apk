import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zaz
  extends abeg
  implements View.OnClickListener
{
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private PhoneContactFragment jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactFragment;
  private boolean bqp;
  private QQAppInterface mApp;
  private Context mContext;
  private View mEmptyView;
  private List<yzr> tE;
  
  public zaz(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean, PhoneContactFragment paramPhoneContactFragment)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.mApp.getManager(11));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactFragment = paramPhoneContactFragment;
  }
  
  private void ie()
  {
    if (this.tE == null)
    {
      this.tE = new ArrayList();
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.xy();
      if ((i == 9) || (i == 8) || (i == 4) || (i == 2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.Uy()) {
          break label85;
        }
        if (QLog.isColorLevel()) {
          QLog.d("contacts.PhoneContactAdapter", 2, "load data: no permission");
        }
      }
    }
    label85:
    do
    {
      do
      {
        return;
        this.tE.clear();
        break;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(new int[] { 7, 2, 3, 4 });
      } while (localObject2 == null);
      if (QLog.isColorLevel()) {
        QLog.d("contacts.PhoneContactAdapter", 2, "load data:" + ((List)localObject2).size());
      }
      localObject1 = new ArrayList(((List)localObject2).size());
      Object localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
        if (!localPhoneContact.isHiden) {
          ((List)localObject1).add(yzq.a(1, localPhoneContact, this.mApp, this.mContext));
        }
      }
      this.tE = ((List)localObject1);
    } while ((!this.bqp) || (this.tE.size() != 0));
    Object localObject1 = (PhoneContactManagerImp)this.mApp.getManager(11);
    if (QLog.isColorLevel()) {
      QLog.d("contacts.PhoneContactAdapter", 2, "needDoubleCheck onAppRunForeground");
    }
    if (localObject1 != null) {
      ((PhoneContactManagerImp)localObject1).AK(true);
    }
    this.bqp = false;
  }
  
  private boolean mA()
  {
    if (this.tE == null) {
      return true;
    }
    return this.tE.isEmpty();
  }
  
  public void bo(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != this.mApp)
    {
      if (QLog.isColorLevel()) {
        QLog.i("contacts.PhoneContactAdapter", 2, "checkResetApp, need change app!");
      }
      this.mApp = paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.mApp.getManager(11));
      bT(this.mApp);
    }
  }
  
  public void clearData()
  {
    if (this.tE != null) {
      this.tE.clear();
    }
  }
  
  public void destroy()
  {
    super.destroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = null;
    this.mApp = null;
    this.mContext = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactFragment = null;
  }
  
  public int getCount()
  {
    if ((this.tE != null) && (mA()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactFragment.UX())) {
      return 1;
    }
    if (this.tE == null) {
      return 0;
    }
    return this.tE.size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (mA())
    {
      if (this.mEmptyView == null)
      {
        this.mEmptyView = View.inflate(this.mContext, 2131559068, null);
        this.mEmptyView.setBackgroundResource(2130839642);
        this.mEmptyView.findViewById(2131369742).setVisibility(8);
        this.mEmptyView.findViewById(2131369847).setVisibility(8);
        localObject1 = (SingleLineTextView)this.mEmptyView.findViewById(2131368187);
        ((SingleLineTextView)localObject1).setText(acfp.m(2131709499));
        localObject2 = (ViewGroup.MarginLayoutParams)((SingleLineTextView)localObject1).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin /= 2;
        ((SingleLineTextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((SimpleTextView)this.mEmptyView.findViewById(2131365243)).setText("0");
      }
      localObject1 = this.mEmptyView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = ((yzr)this.tE.get(paramInt)).a(0, paramInt, paramView, paramViewGroup, this);
      if (localObject1 != null)
      {
        localObject2 = (yzr.b)((View)localObject1).getTag();
        if (((yzr.b)localObject2).pQ != null) {
          ((yzr.b)localObject2).pQ.setBackgroundDrawable(new BitmapDrawable(a(((yzr.b)localObject2).type, ((yzr.b)localObject2).uin)));
        }
        ((View)localObject1).setOnClickListener(this);
        if ((localObject2 instanceof zay.a)) {
          ((zay.a)localObject2).er.setOnClickListener(this);
        }
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.bqp = true;
    ie();
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    int i = 17;
    Object localObject;
    if ((paramView != null) && (paramView.getId() == 2131377201) && ((paramView.getTag() instanceof PhoneContact)))
    {
      localObject = (PhoneContact)paramView.getTag();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.Uv()) {
        break label368;
      }
    }
    for (;;)
    {
      ((PhoneContact)localObject).isNewRecommend = false;
      localObject = AddFriendLogicActivity.a(this.mContext, 2, ((PhoneContact)localObject).unifiedCode, null, 3006, i, ((PhoneContact)localObject).name, null, null, acfp.m(2131709494), null);
      this.mContext.startActivity((Intent)localObject);
      anot.a(this.mApp, "dc00899", "contact", "", "addbook", "add_friend", 0, 0, "", "", "", "");
      do
      {
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        } while ((paramView == null) || (!(paramView.getTag() instanceof yzr.b)));
        localObject = (yzr.b)paramView.getTag();
      } while (!(((yzr.b)localObject).item instanceof PhoneContact));
      PhoneContact localPhoneContact = (PhoneContact)((yzr.b)localObject).item;
      if (QLog.isColorLevel()) {
        QLog.d("contacts.PhoneContactAdapter", 2, "onItemClick:" + localPhoneContact.name + localPhoneContact.mobileCode + "--[" + localPhoneContact.detalStatusFlag + "] [" + localPhoneContact.iTermType + "]");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.Uv()) {
        localObject = new ProfileActivity.AllInOne(localPhoneContact.unifiedCode, 34);
      }
      for (;;)
      {
        ((ProfileActivity.AllInOne)localObject).bJa = 59;
        ((ProfileActivity.AllInOne)localObject).nickname = localPhoneContact.name;
        ((ProfileActivity.AllInOne)localObject).bJc = 2;
        ProfileActivity.b(this.mContext, (ProfileActivity.AllInOne)localObject);
        anot.a(this.mApp, "CliOper", "", "", "0X80053DF", "0X80053DF", 0, 0, "1", "", "", "");
        break;
        localObject = new ProfileActivity.AllInOne(localPhoneContact.unifiedCode, 29);
        ((ProfileActivity.AllInOne)localObject).subSourceId = 17;
      }
      label368:
      i = 15;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt != 0) {
      ApngImage.pauseByTag(3);
    }
    if (paramInt == 0) {
      ApngImage.playByTag(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zaz
 * JD-Core Version:    0.7.0.1
 */