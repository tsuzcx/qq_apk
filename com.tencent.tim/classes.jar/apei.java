import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import cooperation.troop.TroopFileProxyActivity;
import java.util.Map;

public class apei
{
  protected ImageView Ep;
  protected View Il;
  protected Context J;
  protected CheckBox S;
  private apei.a a;
  protected AsyncImageView a;
  protected TextView aau;
  private SparseIntArray ai;
  protected ahav.d b;
  protected apbr b;
  protected apca b;
  protected View.OnClickListener bJ;
  private boolean cPN;
  private boolean cPP;
  private boolean cPR;
  private boolean cQe;
  protected int cYl = 0;
  private String coj;
  protected View convertView;
  protected View.OnLongClickListener d;
  protected EllipsizingTextView d;
  protected CircleFileStateView d;
  protected View.OnClickListener fY;
  protected QQAppInterface mApp;
  protected long mTroopUin;
  
  public apei(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, int paramInt1, int paramInt2)
  {
    this.mApp = paramQQAppInterface;
    this.J = paramContext;
    this.mTroopUin = paramLong;
    this.cYl = paramInt2;
    this.convertView = LayoutInflater.from(paramContext).inflate(paramInt1, null);
    this.Il = this.convertView.findViewById(2131380422);
    this.Il.setTag(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)this.convertView.findViewById(2131380427));
    this.jdField_d_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)this.convertView.findViewById(2131380428));
    this.aau = ((TextView)this.convertView.findViewById(2131380425));
    this.Ep = ((ImageView)this.convertView.findViewById(2131380426));
    this.jdField_d_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)this.convertView.findViewById(2131380423));
    this.S = ((CheckBox)this.convertView.findViewById(2131367036));
    this.jdField_b_of_type_Apca = new apca(this.mTroopUin, this.mApp, (Activity)this.J);
    dYG();
    this.coj = "";
    dYH();
  }
  
  private final void bC(boolean paramBoolean, int paramInt)
  {
    CircleFileStateView localCircleFileStateView = this.jdField_d_of_type_ComTencentMobileqqWidgetCircleFileStateView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localCircleFileStateView.setVisibility(i);
      if (paramInt != -1) {
        break;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
    this.jdField_d_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(paramInt);
    if (paramInt == 1) {
      this.jdField_d_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription(acfp.m(2131715695));
    }
    long l3;
    long l1;
    for (;;)
    {
      long l4 = this.jdField_b_of_type_Apbr.ProgressValue;
      long l2 = this.jdField_b_of_type_Apbr.uint64_file_size;
      l3 = l2;
      l1 = l4;
      if (l4 > l2)
      {
        l1 = l2;
        l3 = l2;
      }
      while (l3 > 2147483647L)
      {
        l3 >>= 1;
        l1 >>= 1;
      }
      if (paramInt == 3) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription(acfp.m(2131715675));
      } else if (paramInt == 2) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription(acfp.m(2131715676));
      } else {
        this.jdField_d_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription("");
      }
    }
    paramInt = (int)(l1 * 100.0D / l3);
    this.jdField_d_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress(paramInt);
  }
  
  private void dYH()
  {
    this.ai = new SparseIntArray();
    this.ai.put(0, 1);
    this.ai.put(1, 1);
    this.ai.put(2, 3);
    this.ai.put(3, 3);
    this.ai.put(6, -1);
    this.ai.put(8, 1);
    this.ai.put(9, 2);
    this.ai.put(10, 2);
    this.ai.put(11, -1);
    this.ai.put(7, -1);
  }
  
  public static String i(Context paramContext, long paramLong)
  {
    paramLong *= 1000L;
    long l = NetConnInfoCenter.getServerTime() * 1000L;
    if (paramLong <= l) {
      return paramContext.getString(2131699546);
    }
    paramLong = (paramLong - l) / 86400000L;
    return paramLong + 1L + paramContext.getString(2131699519);
  }
  
  protected void Rw(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.Ep.setVisibility(0);
      this.coj = this.J.getString(2131693589);
      return;
    }
    this.Ep.setVisibility(4);
    this.coj = "";
  }
  
  public void Rx(boolean paramBoolean)
  {
    this.cPR = paramBoolean;
  }
  
  protected boolean T(View paramView)
  {
    return false;
  }
  
  public void a(long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Apbr == null) {
      return;
    }
    String str1 = "";
    String str2 = "";
    this.coj = "";
    this.jdField_d_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(this.jdField_b_of_type_Apbr);
    this.aau.setTag(this.jdField_b_of_type_Apbr);
    paramContext.getResources();
    this.cPN = this.jdField_b_of_type_Apbr.cPN;
    paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    Object localObject1 = this.jdField_b_of_type_Apbr.str_file_name;
    int i;
    if (!this.cPN)
    {
      if ((!paramBoolean) && (this.jdField_b_of_type_Apbr != null) && (this.jdField_b_of_type_Apbr.ThumbnailFile_Small == null)) {
        paramQQAppInterface.a(this.jdField_b_of_type_Apbr.Id, 128);
      }
      if (aqhq.fileExistsAndNotEmpty(this.jdField_b_of_type_Apbr.ThumbnailFile_Small))
      {
        i = ahav.getFileType(this.jdField_b_of_type_Apbr.str_file_name);
        ahav.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, this.jdField_b_of_type_Apbr.ThumbnailFile_Small, i);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(acfp.m(2131715702));
        label176:
        if (this.cPN) {
          break label560;
        }
        str2 = this.jdField_b_of_type_Apbr.AV();
        paramQQAppInterface = this.jdField_b_of_type_Apbr.AX();
        str1 = this.jdField_b_of_type_Apbr.cod;
        this.jdField_d_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText((CharSequence)localObject1);
        this.jdField_d_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
        this.jdField_d_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        if (this.cPP) {
          paramQQAppInterface = "";
        }
        Object localObject2 = null;
        localObject1 = localObject2;
        if (this.jdField_b_of_type_Apbr.dTh != 0)
        {
          localObject1 = localObject2;
          if (this.jdField_b_of_type_Apbr.dTg != 102) {
            localObject1 = i(paramContext, this.jdField_b_of_type_Apbr.dTh);
          }
        }
        paramBoolean = apbr.a.lY(this.jdField_b_of_type_Apbr.Status);
        i = 1;
        if (!paramBoolean) {
          break label748;
        }
        i = 0;
        label318:
        if ((this.jdField_b_of_type_Apbr.Status != 0) && (this.jdField_b_of_type_Apbr.Status != 1) && (this.jdField_b_of_type_Apbr.Status != 2) && (this.jdField_b_of_type_Apbr.Status != 8) && (this.jdField_b_of_type_Apbr.Status != 9)) {
          break label761;
        }
        paramBoolean = true;
        label377:
        if ((this.jdField_b_of_type_Apbr.Status != 11) && (this.jdField_b_of_type_Apbr.Status != 6)) {
          break label775;
        }
        if (!ahbj.fileExistsAndNotEmpty(this.jdField_b_of_type_Apbr.LocalFile)) {
          break label767;
        }
        Rw(true);
        label419:
        bC(paramBoolean, this.ai.get(this.jdField_b_of_type_Apbr.Status, -1));
        if (i != 0) {
          break label817;
        }
      }
    }
    label560:
    label817:
    for (paramContext = "";; paramContext = paramQQAppInterface)
    {
      if (this.cQe)
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        if (this.jdField_b_of_type_Apbr.cPN) {
          this.S.setVisibility(4);
        }
      }
      for (;;)
      {
        ahbr.a(this.J, this.aau, str1, paramContext, str2, (String)localObject1, this.coj, true, this.jdField_b_of_type_Ahav$d);
        return;
        i = ahav.r(this.jdField_b_of_type_Apbr.str_file_name);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(i);
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130845176);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(acfp.m(2131715718));
        break label176;
        this.jdField_d_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText((CharSequence)localObject1);
        this.jdField_d_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
        this.jdField_d_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (this.jdField_b_of_type_Apbr.nA.size() > 0) {}
        for (paramQQAppInterface = String.format(this.J.getString(2131699584), new Object[] { Integer.valueOf(this.jdField_b_of_type_Apbr.nA.size()) });; paramQQAppInterface = String.format(this.J.getString(2131699547), new Object[] { Integer.valueOf(this.jdField_b_of_type_Apbr.dTl) }))
        {
          localObject1 = this.jdField_b_of_type_Apbr.coe;
          this.aau.setText((String)localObject1 + this.J.getString(2131693588) + paramQQAppInterface);
          paramQQAppInterface = "";
          break;
          if (this.jdField_b_of_type_Apbr.dTl < 0) {
            this.jdField_b_of_type_Apbr.dTl = 0;
          }
        }
        label748:
        if (!this.cPP) {
          break label318;
        }
        i = 0;
        break label318;
        label761:
        paramBoolean = false;
        break label377;
        label767:
        Rw(false);
        break label419;
        Rw(false);
        break label419;
        this.S.setVisibility(0);
        this.S.setChecked(this.cPR);
        continue;
        this.S.setVisibility(8);
      }
    }
  }
  
  public void a(apei.a parama)
  {
    this.jdField_a_of_type_Apei$a = parama;
  }
  
  protected void au(View paramView, int paramInt)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      if (paramView.getId() == 2131380423) {}
      while ((paramView != null) && ((paramView instanceof CircleFileStateView)))
      {
        ((CircleFileStateView)paramView).setState(paramInt);
        return;
        paramView = paramView.findViewById(2131380423);
      }
    }
  }
  
  protected apbr b(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof apbr))) {
      return null;
    }
    return (apbr)paramView;
  }
  
  public void c(long paramLong, QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_b_of_type_Apbr == null) {}
    while ((this.jdField_b_of_type_Apbr.cPN) || (this.jdField_b_of_type_Apbr == null) || (this.jdField_b_of_type_Apbr.ThumbnailFile_Small != null)) {
      return;
    }
    TroopFileTransferManager.a(paramQQAppInterface, paramLong).a(this.jdField_b_of_type_Apbr.Id, 128);
  }
  
  public void d(long paramLong, QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_b_of_type_Apbr == null) {}
    while (this.jdField_b_of_type_Apbr.cPN) {
      return;
    }
    if (aqhq.fileExistsAndNotEmpty(this.jdField_b_of_type_Apbr.ThumbnailFile_Small))
    {
      i = ahav.getFileType(this.jdField_b_of_type_Apbr.str_file_name);
      ahav.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, this.jdField_b_of_type_Apbr.ThumbnailFile_Small, i);
      return;
    }
    int i = ahav.r(this.jdField_b_of_type_Apbr.str_file_name);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(i);
  }
  
  protected void dYG()
  {
    this.bJ = new apej(this);
    this.jdField_d_of_type_AndroidViewView$OnLongClickListener = new apek(this);
    this.fY = new apel(this);
    this.jdField_b_of_type_Ahav$d = new apem(this);
    this.Il.setOnClickListener(this.bJ);
    this.Il.setOnLongClickListener(this.jdField_d_of_type_AndroidViewView$OnLongClickListener);
    this.jdField_d_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.fY);
  }
  
  protected void hT(View paramView)
  {
    paramView = b((TextView)paramView.findViewById(2131380425));
    if (paramView == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.cjr, this.mTroopUin);
    localIntent.putExtra("filter_member_name", paramView.AX());
    localIntent.putExtra("filter_uin", paramView.aqT);
    localIntent.putExtra("folderPath", "/");
    localIntent.putExtra("param_from", 4000);
    TroopFileProxyActivity.a((Activity)this.J, localIntent, this.mApp.getCurrentAccountUin());
  }
  
  protected void hU(View paramView)
  {
    apbr localapbr = b(paramView);
    if (localapbr == null) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.mApp, this.mTroopUin);
    switch (localapbr.Status)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 0: 
    case 1: 
      localTroopFileTransferManager.a(localapbr.Id);
      au(paramView, 3);
      return;
    case 2: 
      this.jdField_b_of_type_Apca.a(localapbr.Id);
      return;
    case 3: 
      this.jdField_b_of_type_Apca.e(localapbr);
      return;
    case 8: 
      localTroopFileTransferManager.d(localapbr.Id);
      au(paramView, 2);
      return;
    case 9: 
      this.jdField_b_of_type_Apca.b(localapbr.Id);
      return;
    case 10: 
      this.jdField_b_of_type_Apca.f(localapbr);
      au(paramView, 2);
      return;
    case 6: 
    case 11: 
      paramView = this.jdField_b_of_type_Apca.a(localapbr);
      int i = this.jdField_b_of_type_Apca.a(localapbr);
      ahbr.a(this.mApp, this.J, null, null, this.mTroopUin, paramView, String.valueOf(localapbr.aqT), localapbr.dTh, i, this.cYl, null, false, false);
      return;
    case 7: 
      this.jdField_b_of_type_Apca.i(localapbr.mFileId, localapbr.str_file_name, localapbr.uint64_file_size, localapbr.dTg);
      au(paramView, 2);
      return;
    case 13: 
      this.jdField_b_of_type_Apca.h(localapbr);
      au(paramView, 1);
      return;
    }
    this.jdField_b_of_type_Apca.a(localapbr, this.J.getString(2131699981), this.J.getString(2131699982));
    au(paramView, 2);
  }
  
  protected void hV(View paramView)
  {
    apbr localapbr = b(paramView.findViewById(2131380423));
    if (localapbr == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!this.cQe) {
            break;
          }
        } while (localapbr.cPN);
        if (!this.cPR) {
          break;
        }
      } while (this.jdField_a_of_type_Apei$a == null);
      this.jdField_a_of_type_Apei$a.a(false, localapbr);
      return;
    } while (this.jdField_a_of_type_Apei$a == null);
    this.jdField_a_of_type_Apei$a.a(true, localapbr);
    return;
    if (!localapbr.cPN)
    {
      switch (localapbr.Status)
      {
      case 4: 
      case 5: 
      default: 
        return;
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
        apcy localapcy = this.jdField_b_of_type_Apca.a(localapbr);
        int i = this.jdField_b_of_type_Apca.a(localapbr);
        paramView = ahbr.a(paramView.findViewById(2131380427), localapbr.str_file_name);
        ahbr.a(this.mApp, this.J, null, null, this.mTroopUin, localapcy, String.valueOf(localapbr.aqT), localapbr.dTh, i, this.cYl, paramView, false, false);
        return;
      case 13: 
        this.jdField_b_of_type_Apca.h(localapbr);
        return;
      }
      this.jdField_b_of_type_Apca.a(localapbr, this.J.getString(2131699981), this.J.getString(2131699982));
      return;
    }
    paramView = new Intent();
    paramView.putExtra(aoaf.cjr, this.mTroopUin);
    paramView.putExtra("folderPath", localapbr.mFileId);
    paramView.putExtra("folderName", localapbr.str_file_name);
    paramView.putExtra("param_from", 2000);
    TroopFileProxyActivity.a((Activity)this.J, paramView, this.mApp.getCurrentAccountUin());
  }
  
  public void setSelectMode(boolean paramBoolean)
  {
    this.cQe = paramBoolean;
  }
  
  public void y(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if ((this.jdField_b_of_type_Apbr != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_Apbr.a(paramQQAppInterface, paramLong)))) {}
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, apbr paramapbr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apei
 * JD-Core Version:    0.7.0.1
 */