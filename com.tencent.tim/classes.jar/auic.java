import android.text.TextUtils;
import com.tencent.cloudfile.BatchRequest;
import com.tencent.cloudfile.BatchResult;
import com.tencent.cloudfile.CloudBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class auic
  extends atgd
{
  auic(auib paramauib) {}
  
  public void a(boolean paramBoolean1, byte[] paramArrayOfByte, int paramInt1, List<BatchResult> paramList, int paramInt2, String paramString, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramArrayOfByte, paramInt1, paramList, paramInt2, paramString, paramBoolean2);
    if (auib.a(this.b, paramArrayOfByte))
    {
      if (!paramBoolean1) {
        break label271;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramString = (BatchResult)paramList.next();
        paramInt2 = 0;
        int i = -1;
        if (paramInt2 < auib.a(this.b).size())
        {
          if ((auib.a(this.b).get(paramInt2) instanceof FileManagerEntity)) {}
          for (paramArrayOfByte = ((FileManagerEntity)auib.a(this.b).get(paramInt2)).cloudFile;; paramArrayOfByte = ((atin)auib.a(this.b).get(paramInt2)).a)
          {
            int j = i;
            if (Arrays.equals(paramArrayOfByte.cloudId, paramString.cloudId))
            {
              j = i;
              if (paramInt1 != 0) {
                j = paramInt2;
              }
            }
            paramInt2 += 1;
            i = j;
            break;
          }
        }
        if (i != -1) {
          auib.a(this.b).remove(i);
        }
      }
      if ((this.b.a != null) && (this.b.a.Pp())) {
        this.b.a.f(paramBoolean1, 4, this.b.isComplete());
      }
      auib.a(this.b);
    }
    label271:
    do
    {
      return;
      if ((TextUtils.isEmpty(paramString)) && (this.b.a != null) && (this.b.a.Pp()))
      {
        this.b.a.qw(BaseApplicationImpl.getContext().getString(2131691575));
        return;
      }
    } while ((this.b.a == null) || (!this.b.a.Pp()));
    this.b.a.qw(paramString);
  }
  
  public void a(boolean paramBoolean1, byte[] paramArrayOfByte, int paramInt1, List<atiu> paramList, boolean paramBoolean2, String paramString, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    super.a(paramBoolean1, paramArrayOfByte, paramInt1, paramList, paramBoolean2, paramString, paramInt2);
    Object localObject;
    if (auib.a(this.b, paramArrayOfByte)) {
      if (paramBoolean1) {
        if ((auib.a(this.b) == null) || (!auib.a(this.b).equals(paramString)) || (paramInt1 == 2) || (paramInt1 == 1))
        {
          if (paramInt1 != 8) {
            break label337;
          }
          localObject = new ArrayList();
          ((List)localObject).addAll(auib.a(this.b));
          bool2 = ((List)localObject).removeAll(paramList);
          auib.a(this.b).clear();
          auib.a(this.b).addAll(paramList);
          if (!bool2) {
            break label251;
          }
          auib.a(this.b).addAll((Collection)localObject);
        }
      }
    }
    for (;;)
    {
      if ((auib.a(this.b)) && (auib.b(this.b, paramArrayOfByte))) {
        auib.a(this.b, auib.a(this.b));
      }
      auib.a(this.b, paramString);
      if ((this.b.a != null) && (this.b.a.Pp())) {
        this.b.a.f(paramBoolean1, paramInt1, this.b.isComplete());
      }
      return;
      label251:
      localObject = this.b;
      if (!paramBoolean2) {}
      for (paramBoolean2 = bool1;; paramBoolean2 = false)
      {
        auib.a((auib)localObject, paramBoolean2);
        if ((paramList == null) || (paramList.isEmpty())) {
          break label325;
        }
        auib.a(this.b, (atiu)paramList.get(paramList.size() - 1));
        break;
      }
      label325:
      auib.a(this.b, null);
      continue;
      label337:
      localObject = this.b;
      if (!paramBoolean2)
      {
        paramBoolean2 = bool2;
        label352:
        auib.a((auib)localObject, paramBoolean2);
        if ((paramList == null) || (paramList.isEmpty())) {
          break label446;
        }
        auib.a(this.b, (atiu)paramList.get(paramList.size() - 1));
      }
      for (;;)
      {
        if (paramInt1 != 2) {
          break label458;
        }
        auib.a(this.b).removeAll(paramList);
        auib.a(this.b).addAll(paramList);
        break;
        paramBoolean2 = false;
        break label352;
        label446:
        auib.a(this.b, null);
      }
      label458:
      auib.a(this.b).clear();
      auib.a(this.b).addAll(paramList);
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, long paramLong, FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    super.a(paramBoolean, paramArrayOfByte, paramLong, paramFileManagerEntity, paramInt, paramString);
    if (auib.a(this.b, paramArrayOfByte))
    {
      if (!paramBoolean) {
        break label117;
      }
      if (!auib.a(this.b).contains(paramFileManagerEntity))
      {
        auib.a(this.b).add(paramFileManagerEntity);
        athu.nJ(auib.a(this.b));
        if ((this.b.a != null) && (this.b.a.Pp())) {
          this.b.a.f(paramBoolean, 3, this.b.isComplete());
        }
      }
    }
    label117:
    while ((this.b.a == null) || (!this.b.a.Pp())) {
      return;
    }
    if (paramInt == 1029) {}
    for (paramArrayOfByte = BaseApplicationImpl.getContext().getString(2131691572);; paramArrayOfByte = paramString)
    {
      if (paramArrayOfByte != null) {}
      for (;;)
      {
        this.b.a.qw(paramArrayOfByte);
        return;
        paramArrayOfByte = BaseApplicationImpl.getContext().getString(2131691571);
      }
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, atin paramatin, String paramString)
  {
    super.a(paramBoolean, paramArrayOfByte, paramatin, paramString);
    if (auib.a(this.b, paramArrayOfByte))
    {
      if (!paramBoolean) {
        break label101;
      }
      if (!auib.a(this.b).contains(paramatin))
      {
        auib.a(this.b).add(0, paramatin);
        if ((this.b.a != null) && (this.b.a.Pp())) {
          this.b.a.f(paramBoolean, 3, this.b.isComplete());
        }
      }
    }
    label101:
    while ((this.b.a == null) || (!this.b.a.Pp())) {
      return;
    }
    if (paramString != null) {}
    for (;;)
    {
      this.b.a.qw(paramString);
      return;
      paramString = BaseApplicationImpl.getContext().getString(2131691573);
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, List<BatchRequest> paramList, byte[] paramArrayOfByte2, int paramInt, String paramString)
  {
    super.a(paramBoolean, paramArrayOfByte1, paramList, paramArrayOfByte2, paramInt, paramString);
    if (auib.a(this.b, paramArrayOfByte1))
    {
      if (paramBoolean)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          paramArrayOfByte2 = (BatchRequest)paramList.next();
          paramInt = 0;
          int i = -1;
          if (paramInt < auib.a(this.b).size())
          {
            if ((auib.a(this.b).get(paramInt) instanceof FileManagerEntity)) {}
            for (paramArrayOfByte1 = ((FileManagerEntity)auib.a(this.b).get(paramInt)).cloudFile;; paramArrayOfByte1 = ((atin)auib.a(this.b).get(paramInt)).a)
            {
              int j = i;
              if (paramArrayOfByte1 != null)
              {
                j = i;
                if (Arrays.equals(paramArrayOfByte1.cloudId, paramArrayOfByte2.cloudId)) {
                  j = paramInt;
                }
              }
              paramInt += 1;
              i = j;
              break;
            }
          }
          if (i != -1) {
            auib.a(this.b).remove(i);
          }
          if ((this.b.a != null) && (this.b.a.Pp()))
          {
            this.b.a.f(paramBoolean, 4, this.b.isComplete());
            this.b.a.showSuccessToast(BaseApplicationImpl.getContext().getString(2131691687));
          }
          auib.a(this.b);
        }
      }
      if ((!TextUtils.isEmpty(paramString)) || (this.b.a == null) || (!this.b.a.Pp())) {
        break label338;
      }
      this.b.a.qw(BaseApplicationImpl.getContext().getString(2131691686));
    }
    label338:
    while ((this.b.a == null) || (!this.b.a.Pp())) {
      return;
    }
    this.b.a.qw(paramString);
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, int paramInt, String paramString2)
  {
    if ((auib.a(this.b, paramArrayOfByte1)) && (paramBoolean))
    {
      paramInt = 0;
      if (paramInt < auib.a(this.b).size())
      {
        if ((auib.a(this.b).get(paramInt) instanceof FileManagerEntity))
        {
          paramArrayOfByte1 = ((FileManagerEntity)auib.a(this.b).get(paramInt)).cloudFile;
          if (Arrays.equals(paramArrayOfByte1.cloudId, paramArrayOfByte2))
          {
            paramArrayOfByte1.showName = paramString1;
            ((FileManagerEntity)auib.a(this.b).get(paramInt)).fileName = paramString1;
          }
        }
        for (;;)
        {
          paramInt += 1;
          break;
          paramArrayOfByte1 = ((atin)auib.a(this.b).get(paramInt)).a;
          if (Arrays.equals(paramArrayOfByte1.cloudId, paramArrayOfByte2))
          {
            paramArrayOfByte1.showName = paramString1;
            ((atin)auib.a(this.b).get(paramInt)).name = paramString1;
          }
        }
      }
      if ((this.b.a != null) && (this.b.a.Pp()))
      {
        this.b.a.showSuccessToast(BaseApplicationImpl.getContext().getString(2131691689));
        this.b.a.f(paramBoolean, 5, this.b.isComplete());
      }
      ((ateh)auib.a(this.b).getBusinessHandler(180)).a(auib.a(this.b), 8, null);
    }
    do
    {
      return;
      if (((auib.a(this.b, paramArrayOfByte1)) || (auib.a(this.b, paramArrayOfByte2))) && (!paramBoolean) && (TextUtils.isEmpty(paramString2)) && (this.b.a != null) && (this.b.a.Pp()))
      {
        this.b.a.qw(BaseApplicationImpl.getContext().getString(2131691688));
        return;
      }
    } while (((!auib.a(this.b, paramArrayOfByte1)) && (!auib.a(this.b, paramArrayOfByte2))) || (paramBoolean) || (TextUtils.isEmpty(paramString2)) || (this.b.a == null) || (!this.b.a.Pp()));
    this.b.a.qw(paramString2);
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, String paramString)
  {
    super.a(paramBoolean, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt1, paramInt2, paramString);
    if ((auib.a(this.b, paramArrayOfByte1)) && (this.b.a != null) && (this.b.a.Pp()))
    {
      if (!paramBoolean) {
        break label76;
      }
      this.b.a.showSuccessToast(BaseApplicationImpl.getContext().getString(2131691569));
    }
    label76:
    do
    {
      return;
      if ((TextUtils.isEmpty(paramString)) && (this.b.a != null) && (this.b.a.Pp()))
      {
        this.b.a.qw(BaseApplicationImpl.getContext().getString(2131691568));
        return;
      }
    } while ((this.b.a == null) || (!this.b.a.Pp()));
    this.b.a.qw(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auic
 * JD-Core Version:    0.7.0.1
 */