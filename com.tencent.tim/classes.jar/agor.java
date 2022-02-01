import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.ArrayList;
import java.util.UUID;

public class agor
  implements ampx
{
  private CharSequence V;
  private CharSequence W;
  private apen a;
  private QQAppInterface mApp;
  private Context mContext;
  private String wB;
  
  public agor(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, apen paramapen)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.a = paramapen;
    this.wB = paramString;
    diA();
  }
  
  private void diA()
  {
    if (this.a == null) {
      return;
    }
    Object localObject4 = "";
    long l1 = this.a.groupCode;
    long l2 = this.a.uploaderUin;
    long l3 = this.a.aqV;
    apbr localapbr = this.a.b;
    Object localObject1 = ((TroopManager)this.mApp.getManager(52)).b(String.valueOf(l1), String.valueOf(l2));
    int i;
    Object localObject2;
    label107:
    Object localObject3;
    if ((localObject1 != null) && (aqgv.bS(((TroopMemberInfo)localObject1).troopnick, String.valueOf(l3))))
    {
      i = 1;
      if (i == 0) {
        break label444;
      }
      localObject2 = ((TroopMemberInfo)localObject1).troopnick;
      if (this.a.aqV <= 0L) {
        break label593;
      }
      localObject3 = String.valueOf(this.a.aqV);
      localObject4 = apeo.a();
      localObject1 = ((apeo)localObject4).a((String)localObject3);
      if (localObject1 == null) {
        break label450;
      }
      i = apeo.a(this.wB, (String)localObject2, this.a.col, ((amjk)localObject1).cay, ((amjk)localObject1).caz, this.a.com, ((amjk)localObject1).caw, ((amjk)localObject1).cax);
      localObject1 = apeo.b((String)localObject2, this.a.col, this.a.com, i);
      label216:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label515;
      }
      if (!TextUtils.isEmpty(this.a.col)) {
        break label503;
      }
      localObject1 = this.a.com;
      label246:
      localObject3 = "";
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      label258:
      localObject3 = localObject2;
      if ((this.a.BP != null) && (this.a.BP.size() > 0))
      {
        localObject2 = (String)this.a.BP.get(0);
        if ((TextUtils.isEmpty(localapbr.str_file_name)) || (!localapbr.str_file_name.toLowerCase().contains(((String)localObject2).toLowerCase()))) {}
      }
      for (;;)
      {
        this.V = localapbr.str_file_name;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.V = amxk.a(localapbr.str_file_name, (String)localObject2);
        }
        localObject2 = localapbr.AV();
        localObject4 = localapbr.cod;
        Object localObject5 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject5).append((CharSequence)localObject4).append("  ");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((SpannableStringBuilder)localObject5).append(amxk.a((String)localObject3, (String)localObject1)).append("  ");
        }
        for (;;)
        {
          ((SpannableStringBuilder)localObject5).append((CharSequence)localObject2);
          this.W = ((CharSequence)localObject5);
          return;
          i = 0;
          break;
          label444:
          localObject2 = null;
          break label107;
          label450:
          i = apeo.a(this.wB, (String)localObject2, this.a.col, null, null, this.a.com, null, null);
          localObject1 = apeo.b((String)localObject2, this.a.col, this.a.com, i);
          break label216;
          label503:
          localObject1 = this.a.col;
          break label246;
          label515:
          if ((i == 1) || (i == 4) || (i == 7))
          {
            localObject3 = this.wB;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break label258;
          }
          if ((i != 5) && (i != 6) && (i != 2) && (i != 3)) {
            break label738;
          }
          localObject3 = ((apeo)localObject4).bL(this.wB, (String)localObject3);
          localObject2 = localObject1;
          localObject1 = localObject3;
          break label258;
          label593:
          if (i != 0) {}
          for (;;)
          {
            localObject3 = localObject2;
            localObject1 = localObject4;
            if (this.a.BP == null) {
              break;
            }
            localObject3 = localObject2;
            localObject1 = localObject4;
            if (this.a.BP.size() <= 0) {
              break;
            }
            localObject5 = (String)this.a.BP.get(0);
            localObject3 = localObject2;
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break;
            }
            localObject3 = localObject2;
            localObject1 = localObject4;
            if (!((String)localObject2).toLowerCase().contains(((String)localObject5).toLowerCase())) {
              break;
            }
            localObject1 = localObject5;
            localObject3 = localObject2;
            break;
            localObject2 = this.a.cok;
          }
          ((SpannableStringBuilder)localObject5).append((CharSequence)localObject3).append("  ");
        }
        localObject2 = "";
      }
      label738:
      localObject2 = localObject1;
      localObject1 = "";
    }
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public void cR(View paramView)
  {
    Object localObject = TroopFileTransferManager.a(this.mApp, this.a.groupCode);
    apbr localapbr = this.a.b;
    apcy localapcy = ((TroopFileTransferManager)localObject).a(localapbr.mFileId);
    localObject = localapcy;
    if (localapcy == null)
    {
      localObject = apsv.a(this.mApp, this.a.groupCode, localapbr.Id.toString(), localapbr.mFileId, localapbr.str_file_name, localapbr.uint64_file_size, localapbr.dTg);
      ((apcy)localObject).ThumbnailFile_Large = localapbr.ThumbnailFile_Large;
      ((apcy)localObject).coc = localapbr.coc;
      ((apcy)localObject).ThumbnailFile_Small = localapbr.ThumbnailFile_Small;
    }
    if ((localObject != null) && (((apcy)localObject).ProgressTotal == 0L)) {
      ((apcy)localObject).ProgressTotal = localapbr.uint64_file_size;
    }
    paramView = ahbr.a(paramView.findViewById(2131367020), localapbr.str_file_name);
    ahbr.a(this.mApp, this.mContext, null, null, this.a.groupCode, (apcy)localObject, localapbr.cob, localapbr.dTh, 2, 4, paramView, false, false);
  }
  
  public void cW(int paramInt1, int paramInt2) {}
  
  public CharSequence f()
  {
    return null;
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    return this.W;
  }
  
  public String getFileName()
  {
    if (this.a.b != null) {
      return this.a.b.str_file_name;
    }
    return "";
  }
  
  public String getKeyword()
  {
    return this.wB;
  }
  
  public CharSequence getTitle()
  {
    return this.V;
  }
  
  public String getUin()
  {
    return null;
  }
  
  public int pE()
  {
    return 0;
  }
  
  public int pF()
  {
    return 0;
  }
  
  public int pG()
  {
    return 0;
  }
  
  public String vp()
  {
    String str = "";
    Object localObject = TroopFileTransferManager.a(this.mApp, this.a.groupCode);
    apbr localapbr = this.a.b;
    apcy localapcy = ((TroopFileTransferManager)localObject).a(localapbr.mFileId);
    if (localapcy != null) {
      str = localapcy.ThumbnailFile_Small;
    }
    for (;;)
    {
      localObject = str;
      if (!aqhq.fileExistsAndNotEmpty(str)) {
        localObject = this.a.b.ThumbnailFile_Small;
      }
      return localObject;
      ((TroopFileTransferManager)localObject).a(localapbr.Id, 128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agor
 * JD-Core Version:    0.7.0.1
 */