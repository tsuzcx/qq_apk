import com.tencent.mobileqq.activity.recent.HotChatCenterItemBuilder;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemAppletsFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg;
import com.tencent.mobileqq.activity.recent.data.RecentItemContactsGuideData;
import com.tencent.mobileqq.activity.recent.data.RecentItemImaxADData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendData;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNearbyLiveTipData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountADFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemRecommendTroopData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.apollo.activity.RecentHotchatItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;

public class aakd
{
  public static final Long P = Long.valueOf(1L);
  public static final Long Q = Long.valueOf(2L);
  public static final Long R = Long.valueOf(4L);
  public static final Long S = Long.valueOf(5L);
  public static final Long T = Long.valueOf(6L);
  protected static final int[] jg = { 0 };
  protected static final int[] jh = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
  protected static final int[] ji = { 0, 1, 2, 3 };
  protected static final int[] jj = { 0, 1 };
  protected static final int[] jk = { 0, 1, 2, 3 };
  protected static final int[] jl = { 0, 1, 2 };
  protected static final int[] jm = { 0, 1, 2 };
  protected static final int[] jn = { 0, 1, 2 };
  protected static final int[] jo = { 0, 1, 2, 3, 4 };
  protected static final int[] jp = { 0, 1, 2, 3 };
  protected static final int[] jq = { 0, 1, 2, 3 };
  protected static final int[] jr = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
  protected aakb[] a;
  protected aajg d;
  protected int[] js;
  protected int mStyle;
  
  public aakd(int paramInt)
  {
    this.mStyle = paramInt;
    if (this.mStyle == 0) {
      this.js = jh;
    }
    for (;;)
    {
      this.a = new aakb[this.js.length];
      return;
      if (this.mStyle == 1) {
        this.js = jk;
      } else if (this.mStyle == 5) {
        this.js = jm;
      } else if (this.mStyle == 6) {
        this.js = ji;
      } else if (this.mStyle == 7) {
        this.js = jj;
      } else if (this.mStyle == 9) {
        this.js = jn;
      } else if (this.mStyle == 10) {
        this.js = jo;
      } else if (this.mStyle == 11) {
        this.js = jp;
      } else if (this.mStyle == 12) {
        this.js = jl;
      } else if (this.mStyle == 13) {
        this.js = jq;
      } else if (this.mStyle == 4) {
        this.js = jr;
      } else {
        this.js = jg;
      }
    }
  }
  
  public aakb a(Object paramObject)
  {
    Object localObject = null;
    int i = h(paramObject);
    if (this.mStyle == 0) {
      if (i == 1)
      {
        if (this.a[1] == null) {
          this.a[1] = new aajw();
        }
        paramObject = this.a[1];
      }
    }
    for (;;)
    {
      localObject = paramObject;
      if (paramObject == null)
      {
        if (this.a[0] == null) {
          this.a[0] = new aajo();
        }
        localObject = this.a[0];
      }
      ((aakb)localObject).a(this.d);
      return localObject;
      if (i == 2)
      {
        if (this.a[2] == null) {
          this.a[2] = new aajv();
        }
        paramObject = this.a[2];
      }
      else if (i == 3)
      {
        if (this.a[3] == null) {
          this.a[3] = new aakv();
        }
        paramObject = this.a[3];
      }
      else if (i == 4)
      {
        if (this.a[4] == null) {
          this.a[4] = new aajy();
        }
        paramObject = this.a[4];
      }
      else if (i == 5)
      {
        if (this.a[5] == null) {
          this.a[5] = new aajp();
        }
        paramObject = this.a[5];
      }
      else if (i == 6)
      {
        if (this.a[6] == null) {
          this.a[6] = new aakf();
        }
        paramObject = this.a[6];
      }
      else if (i == 7)
      {
        if (this.a[7] == null) {
          this.a[7] = new aakh();
        }
        paramObject = this.a[7];
      }
      else if (i == 8)
      {
        if (this.a[8] == null) {
          this.a[8] = new aajn();
        }
        paramObject = this.a[8];
      }
      else if (i == 9)
      {
        if (this.a[9] == null) {
          this.a[9] = new aajr();
        }
        paramObject = this.a[9];
      }
      else
      {
        paramObject = localObject;
        if (i == 10)
        {
          if (this.a[10] == null) {
            this.a[10] = new aaky();
          }
          paramObject = this.a[10];
          continue;
          if (this.mStyle == 1)
          {
            if (i == 1)
            {
              if (this.a[1] == null) {
                this.a[1] = new aalg();
              }
              paramObject = this.a[1];
            }
            else if (i == 2)
            {
              if (this.a[2] == null) {
                this.a[2] = new aaju();
              }
              paramObject = this.a[2];
            }
            else
            {
              paramObject = localObject;
              if (i == 3)
              {
                if (this.a[3] == null) {
                  this.a[3] = new aalf();
                }
                paramObject = this.a[3];
              }
            }
          }
          else if (this.mStyle == 12)
          {
            if (i == 1)
            {
              if (this.a[1] == null) {
                this.a[1] = new aalg();
              }
              paramObject = this.a[1];
            }
            else
            {
              paramObject = localObject;
              if (i == 2)
              {
                if (this.a[2] == null) {
                  this.a[2] = new aaju();
                }
                paramObject = this.a[2];
              }
            }
          }
          else if (this.mStyle == 9)
          {
            if (i == 1)
            {
              if (this.a[1] == null) {
                this.a[1] = new aalg();
              }
              paramObject = this.a[1];
            }
            else
            {
              paramObject = localObject;
              if (i == 2)
              {
                if (this.a[2] == null) {
                  this.a[2] = new aaju();
                }
                paramObject = this.a[2];
              }
            }
          }
          else if (this.mStyle == 5)
          {
            if (i == 1)
            {
              if (this.a[1] == null) {
                this.a[1] = new aajo();
              }
              paramObject = this.a[1];
            }
            else
            {
              paramObject = localObject;
              if (i == 2)
              {
                if (this.a[2] == null) {
                  this.a[2] = new aaju();
                }
                paramObject = this.a[2];
              }
            }
          }
          else if (this.mStyle == 6)
          {
            if (i == 2)
            {
              if (this.a[2] == null) {
                this.a[2] = new aalc();
              }
              paramObject = this.a[2];
            }
            else if (i == 1)
            {
              if (this.a[1] == null) {
                this.a[1] = new aaju();
              }
              paramObject = this.a[1];
            }
            else
            {
              paramObject = localObject;
              if (i == 3)
              {
                if (this.a[3] == null) {
                  this.a[3] = new aake();
                }
                paramObject = this.a[3];
              }
            }
          }
          else if (this.mStyle == 7)
          {
            paramObject = localObject;
            if (i == 1)
            {
              if (this.a[1] == null) {
                this.a[1] = new aald();
              }
              paramObject = this.a[1];
            }
          }
          else if (this.mStyle == 10)
          {
            paramObject = localObject;
            if (i > 0)
            {
              paramObject = localObject;
              if (i < this.a.length)
              {
                localObject = this.a[i];
                paramObject = localObject;
                if (localObject == null)
                {
                  switch (i)
                  {
                  default: 
                    paramObject = localObject;
                  }
                  for (;;)
                  {
                    this.a[i] = paramObject;
                    break;
                    paramObject = new aaju();
                    continue;
                    paramObject = new aalg();
                    continue;
                    paramObject = new HotChatCenterItemBuilder();
                    continue;
                    paramObject = new aaiz();
                  }
                }
              }
            }
          }
          else if (this.mStyle == 11)
          {
            paramObject = localObject;
            if (i > 0)
            {
              paramObject = localObject;
              if (i < this.a.length)
              {
                localObject = this.a[i];
                paramObject = localObject;
                if (localObject == null)
                {
                  switch (i)
                  {
                  default: 
                    paramObject = localObject;
                  }
                  for (;;)
                  {
                    this.a[i] = paramObject;
                    break;
                    paramObject = new aajq();
                    continue;
                    paramObject = new aegr();
                  }
                }
              }
            }
          }
          else if (this.mStyle == 13)
          {
            paramObject = localObject;
            if (i > 0)
            {
              paramObject = localObject;
              if (i < this.a.length)
              {
                localObject = this.a[i];
                paramObject = localObject;
                if (localObject == null)
                {
                  switch (i)
                  {
                  default: 
                    paramObject = localObject;
                  }
                  for (;;)
                  {
                    this.a[i] = paramObject;
                    break;
                    paramObject = new aajv();
                    continue;
                    paramObject = new ajaa();
                  }
                }
              }
            }
          }
          else
          {
            paramObject = localObject;
            if (this.mStyle == 4) {
              if (i == 4)
              {
                if (this.a[4] == null) {
                  this.a[4] = new atdf();
                }
                paramObject = this.a[4];
              }
              else if (i == 5)
              {
                if (this.a[5] == null) {
                  this.a[5] = new atdg();
                }
                paramObject = this.a[5];
              }
              else if (i == 6)
              {
                if (this.a[6] == null) {
                  this.a[6] = new atdo();
                }
                paramObject = this.a[6];
              }
              else if (i == 1)
              {
                if (this.a[1] == null) {
                  this.a[1] = new aajw();
                }
                paramObject = this.a[1];
              }
              else if (i == 2)
              {
                if (this.a[2] == null) {
                  this.a[2] = new atdp();
                }
                paramObject = this.a[2];
              }
              else if (i == 3)
              {
                if (this.a[3] == null) {
                  this.a[3] = new atdp(1);
                }
                paramObject = this.a[3];
              }
              else
              {
                paramObject = localObject;
                if (i != 7)
                {
                  paramObject = localObject;
                  if (i == 8) {
                    paramObject = localObject;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(aajg paramaajg)
  {
    this.d = paramaajg;
  }
  
  public void bH(QQAppInterface paramQQAppInterface)
  {
    if ((this.mStyle == 0) && (this.a != null) && (this.a.length > 6) && ((this.a[6] instanceof aakf)))
    {
      ((aakf)this.a[6]).destroy();
      this.a[6] = null;
    }
  }
  
  public int getViewTypeCount()
  {
    return this.js.length;
  }
  
  public int h(Object paramObject)
  {
    int i = this.js[0];
    switch (this.mStyle)
    {
    case 2: 
    case 3: 
    case 8: 
    default: 
      return i;
    case 0: 
      if ((paramObject instanceof Integer))
      {
        if (((Integer)paramObject).intValue() != 0) {
          break label974;
        }
        i = this.js[1];
      }
      break;
    }
    label974:
    for (;;)
    {
      return i;
      if ((paramObject instanceof RecentUserBaseData))
      {
        if ((paramObject instanceof RecentItemPublicAccountADFolderData)) {
          return this.js[3];
        }
        if ((paramObject instanceof RecentItemImaxADData)) {
          return this.js[4];
        }
        if ((paramObject instanceof RecentItemChatMsgData)) {
          return this.js[5];
        }
        if ((paramObject instanceof RecentItemMayKnowFriendData)) {
          return this.js[6];
        }
        if ((paramObject instanceof RecentItemMayKnowFriendVerticalListData)) {
          return this.js[7];
        }
        if ((paramObject instanceof RecentItemAppletsFolderData)) {
          return this.js[8];
        }
        if ((paramObject instanceof RecentItemContactsGuideData)) {
          return this.js[9];
        }
        if ((paramObject instanceof RecentItemRecommendTroopData)) {
          return this.js[10];
        }
        return this.js[2];
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      return this.js[0];
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        if (paramObject.intValue() == 3) {
          return this.js[3];
        }
        if (paramObject.intValue() == 4) {
          return this.js[1];
        }
        if (paramObject.intValue() != 5) {
          break;
        }
        return this.js[1];
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break;
      }
      return this.js[2];
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        if (paramObject.intValue() == 18) {
          return this.js[1];
        }
        if (paramObject.intValue() != 19) {
          break;
        }
        return this.js[1];
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break;
      }
      return this.js[2];
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        if (paramObject.intValue() == 11) {
          return this.js[1];
        }
        if (paramObject.intValue() != 12) {
          break;
        }
        return this.js[1];
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break;
      }
      return this.js[2];
      if ((paramObject instanceof Integer)) {
        return this.js[1];
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break;
      }
      return this.js[2];
      if ((paramObject instanceof String)) {
        return this.js[0];
      }
      if ((paramObject instanceof RecentSayHelloBoxItem)) {
        return this.js[2];
      }
      if ((paramObject instanceof RecentItemNearbyLiveTipData)) {
        return this.js[3];
      }
      if (!(paramObject instanceof RecentMsgBoxItem)) {
        break;
      }
      return this.js[1];
      if ((paramObject instanceof String)) {
        return this.js[0];
      }
      if (!(paramObject instanceof RecentSayHelloListItem)) {
        break;
      }
      return this.js[1];
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        if (paramObject.intValue() == 13) {
          return this.js[2];
        }
        if (paramObject.intValue() != 4) {
          break;
        }
        return this.js[1];
      }
      if (!(paramObject instanceof RecentHotchatItem)) {
        break;
      }
      switch (((RecentHotchatItem)paramObject).mType)
      {
      default: 
        return i;
      case 1: 
        return this.js[3];
      case 4: 
        return this.js[4];
      case 2: 
        return this.js[2];
      }
      return this.js[1];
      if ((paramObject instanceof RecentItemConfessMsg)) {
        return this.js[1];
      }
      if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 16)) {
        return this.js[2];
      }
      if ((!(paramObject instanceof Integer)) || (((Integer)paramObject).intValue() != 17)) {
        break;
      }
      return this.js[3];
      if ((paramObject instanceof RecentMatchChatListItem)) {
        return this.js[1];
      }
      if (((paramObject instanceof Integer)) && (((Integer)paramObject).intValue() == 20)) {
        return this.js[2];
      }
      if ((!(paramObject instanceof Integer)) || (((Integer)paramObject).intValue() != 21)) {
        break;
      }
      return this.js[3];
      if ((paramObject instanceof Long))
      {
        paramObject = (Long)paramObject;
        if (P == paramObject) {
          return this.js[4];
        }
        if (R == paramObject) {
          return this.js[5];
        }
        if (Q == paramObject) {
          return this.js[6];
        }
        if (S == paramObject) {
          return this.js[7];
        }
        if (T != paramObject) {
          break;
        }
        return this.js[8];
      }
      if ((paramObject instanceof Integer)) {
        return this.js[1];
      }
      if ((paramObject instanceof RecentBaseData))
      {
        i = ((RecentBaseData)paramObject).ng();
        int j = ((RecentBaseData)paramObject).mAuthenIconId;
        if ((i == 8) || ((i == 26) && (j != 2))) {}
        for (i = this.js[3];; i = this.js[2]) {
          return i;
        }
      }
      if (!(paramObject instanceof String)) {
        break;
      }
      return this.js[0];
    }
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    if ((this.mStyle == 0) && (this.a != null) && (this.a.length > 6) && ((this.a[6] instanceof aakf)))
    {
      ((aakf)this.a[6]).destroy();
      this.a[6] = null;
    }
  }
  
  public int yH()
  {
    return this.mStyle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aakd
 * JD-Core Version:    0.7.0.1
 */