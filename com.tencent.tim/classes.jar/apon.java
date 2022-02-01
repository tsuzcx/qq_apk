import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class apon
  implements apok.a
{
  apol b;
  boolean cRO;
  private Bitmap gt;
  
  public apon(apol paramapol)
  {
    this.b = paramapol;
    init();
  }
  
  public static ChatHistoryTroopMemberFragment.a a()
  {
    ChatHistoryTroopMemberFragment.a locala = new ChatHistoryTroopMemberFragment.a();
    locala.uin = "0";
    locala.displayName = acfp.m(2131712631);
    locala.remark = acfp.m(2131712634);
    locala.nickname = acfp.m(2131712632);
    locala.aRk = ChnToSpell.aJ(locala.remark, 1);
    locala.aRj = ChnToSpell.aJ(locala.remark, 2);
    return locala;
  }
  
  public static ArrayList<ChatHistoryTroopMemberFragment.a> a(String paramString, List<ChatHistoryTroopMemberFragment.a> paramList, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    paramQQAppInterface = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatHistoryTroopMemberFragment.a locala = (ChatHistoryTroopMemberFragment.a)paramList.next();
      if ((apof.bP(locala.remark, paramString)) || (apof.bP(locala.aRj, paramString)) || (apof.bP(locala.aRk, paramString)))
      {
        locala.bah = locala.remark;
        locala.bai = locala.aRk;
        locala.baj = locala.aRj;
        paramQQAppInterface.add(locala);
      }
      else if ((apof.bP(locala.aRl, paramString)) || (apof.bP(locala.aRm, paramString)) || (apof.bP(locala.aRn, paramString)))
      {
        locala.bah = locala.aRl;
        locala.bai = locala.aRn;
        locala.baj = locala.aRm;
        paramQQAppInterface.add(locala);
      }
      else if ((apof.bP(locala.nickname, paramString)) || (apof.bP(locala.aRh, paramString)) || (apof.bP(locala.aRi, paramString)))
      {
        locala.bah = locala.nickname;
        locala.bai = locala.aRi;
        locala.baj = locala.aRh;
        paramQQAppInterface.add(locala);
      }
      else
      {
        String str1;
        String str2;
        String str3;
        if (apof.bP(locala.uin, paramString))
        {
          str1 = apof.c(locala);
          str2 = apof.d(locala);
          str3 = apof.e(locala);
          locala.bah = str1;
          locala.bai = str3;
          locala.baj = str2;
          paramQQAppInterface.add(locala);
        }
        else if (a(locala, paramString, paramTroopInfo))
        {
          str1 = apof.c(locala);
          str2 = apof.d(locala);
          str3 = apof.e(locala);
          locala.bah = str1;
          locala.bai = str3;
          locala.baj = str2;
          paramQQAppInterface.add(locala);
        }
        else if (b(locala, paramString, paramTroopInfo))
        {
          str1 = apof.c(locala);
          str2 = apof.d(locala);
          str3 = apof.e(locala);
          locala.bah = str1;
          locala.bai = str3;
          locala.baj = str2;
          paramQQAppInterface.add(locala);
        }
        else if (c(locala, paramString, paramTroopInfo))
        {
          str1 = apof.c(locala);
          str2 = apof.d(locala);
          str3 = apof.e(locala);
          locala.bah = str1;
          locala.bai = str3;
          locala.baj = str2;
          paramQQAppInterface.add(locala);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static List<ChatHistoryTroopMemberFragment.a> a(QQAppInterface paramQQAppInterface, List<ChatHistoryTroopMemberFragment.a> paramList, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramList;
    }
    paramQQAppInterface = (aptw)paramQQAppInterface.getManager(203);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatHistoryTroopMemberFragment.a locala = (ChatHistoryTroopMemberFragment.a)paramList.next();
      if (!paramQQAppInterface.gM(locala.uin)) {
        localArrayList.add(locala);
      }
    }
    return localArrayList;
  }
  
  private static boolean a(ChatHistoryTroopMemberFragment.a parama, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    ChatHistoryTroopMemberFragment.a locala = new ChatHistoryTroopMemberFragment.a();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (parama != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopOwner(parama.uin))
        {
          locala.displayName = acfp.m(2131712633);
          locala.remark = acfp.m(2131712629);
          locala.aRk = ChnToSpell.aJ(locala.remark, 1);
          locala.aRj = ChnToSpell.aJ(locala.remark, 2);
          if ((!apof.bP(locala.remark, paramString)) && (!apof.bP(locala.aRj, paramString)))
          {
            bool1 = bool2;
            if (!apof.bP(locala.aRk, paramString)) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString, ChatHistoryTroopMemberFragment.a parama)
  {
    if ("all".equalsIgnoreCase(paramString)) {}
    String str1;
    String str2;
    do
    {
      return true;
      str1 = apof.c(parama);
      str2 = apof.d(parama);
      parama = apof.e(parama);
    } while ((apof.bP(str1, paramString)) || (apof.bP(str2, paramString)) || (apof.bP(parama, paramString)));
    return false;
  }
  
  private static boolean b(ChatHistoryTroopMemberFragment.a parama, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    ChatHistoryTroopMemberFragment.a locala = new ChatHistoryTroopMemberFragment.a();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (parama != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopAdmin(parama.uin))
        {
          locala.displayName = acfp.m(2131712625);
          locala.remark = acfp.m(2131712628);
          locala.aRk = ChnToSpell.aJ(locala.remark, 1);
          locala.aRj = ChnToSpell.aJ(locala.remark, 2);
          if ((!apof.bP(locala.remark, paramString)) && (!apof.bP(locala.aRj, paramString)))
          {
            bool1 = bool2;
            if (!apof.bP(locala.aRk, paramString)) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean c(ChatHistoryTroopMemberFragment.a parama, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    paramTroopInfo = new ChatHistoryTroopMemberFragment.a();
    boolean bool1 = bool2;
    if (parama != null)
    {
      bool1 = bool2;
      if (parama.isTroopFollowed)
      {
        paramTroopInfo.displayName = acfp.m(2131712626);
        paramTroopInfo.remark = acfp.m(2131712630);
        paramTroopInfo.aRk = ChnToSpell.aJ(paramTroopInfo.remark, 1);
        paramTroopInfo.aRj = ChnToSpell.aJ(paramTroopInfo.remark, 2);
        if ((!apof.bP(paramTroopInfo.remark, paramString)) && (!apof.bP(paramTroopInfo.aRj, paramString)))
        {
          bool1 = bool2;
          if (!apof.bP(paramTroopInfo.aRk, paramString)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  boolean aBq()
  {
    return this.b.ai.size() >= 20;
  }
  
  void eaY()
  {
    QQToast.a(BaseApplicationImpl.context, 0, acfp.m(2131712627), 0).show();
  }
  
  public void ii(View paramView)
  {
    boolean bool = false;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (this.cRO)
      {
        paramView.setText(2131696127);
        if (this.b.a != null) {
          this.b.a.azJ();
        }
        if (!this.cRO) {
          bool = true;
        }
        this.cRO = bool;
      }
    }
    else
    {
      return;
    }
    paramView.setText(2131721066);
    if (this.b.cRG) {
      this.b.notifyDataSetChanged();
    }
    for (;;)
    {
      anot.a(this.b.app, "dc00898", "", "", "0X800A48F", "0X800A48F", 0, 0, "", "", "", "");
      break;
      this.b.a.de(this.b.cqk, true);
    }
  }
  
  void init()
  {
    Bitmap localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130843306);
    this.gt = this.b.app.getRoundFaceBitmap(localBitmap);
  }
  
  void z(ImageView paramImageView)
  {
    if (paramImageView != null) {
      paramImageView.setImageBitmap(this.gt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apon
 * JD-Core Version:    0.7.0.1
 */