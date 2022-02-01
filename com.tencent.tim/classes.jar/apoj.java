import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar.a;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBarTipsLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

public class apoj
  implements IndexBar.a
{
  public QQAppInterface app;
  public apol b;
  public IndexBarTipsLayout b;
  public IndexBar c;
  public Context context;
  private String cqj = "";
  public XListView listView;
  private final View mContentView;
  
  public apoj(QQAppInterface paramQQAppInterface, Context paramContext, TroopChatPie paramTroopChatPie, View paramView, XListView paramXListView)
  {
    this.app = paramQQAppInterface;
    this.context = paramContext;
    this.mContentView = paramView;
    this.listView = paramXListView;
    this.jdField_b_of_type_Apol = new apol(this, paramTroopChatPie);
    this.listView.setAdapter(this.jdField_b_of_type_Apol);
    initViews();
  }
  
  private void initViews()
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout = ((IndexBarTipsLayout)this.mContentView.findViewById(2131369143));
    this.c = ((IndexBar)this.mContentView.findViewById(2131369142));
    this.c.setOnIndexBarTouchListener(this);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout.setVisibility(8);
  }
  
  public void Bf(boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ListViewWrapper", 2, new Object[] { "onLetterTouching: invoked. ", " touching: ", Boolean.valueOf(paramBoolean) });
    }
    if (!paramBoolean) {
      this.cqj = "";
    }
    IndexBarTipsLayout localIndexBarTipsLayout;
    if (this.jdField_b_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout != null)
    {
      localIndexBarTipsLayout = this.jdField_b_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout;
      if (!paramBoolean) {
        break label67;
      }
    }
    for (;;)
    {
      localIndexBarTipsLayout.setVisibility(i);
      return;
      label67:
      i = 8;
    }
  }
  
  public void b(String paramString, int paramInt, float paramFloat)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBarTipsLayout.setText(paramString, paramFloat);
    }
    if (!this.cqj.equals(paramString))
    {
      this.cqj = paramString;
      if (!"★".equals(paramString)) {
        break label50;
      }
      this.listView.setSelection(0);
    }
    label50:
    do
    {
      return;
      paramInt = this.jdField_b_of_type_Apol.m(paramString);
    } while (paramInt == -1);
    this.listView.setSelection(paramInt + this.listView.getHeaderViewsCount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apoj
 * JD-Core Version:    0.7.0.1
 */