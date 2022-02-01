import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.auth.AuthResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class arti
  implements BusinessObserver
{
  arti(arth paramarth, long paramLong, asav paramasav, artd paramartd, boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis() - this.Eq;
    Object localObject1 = paramBundle.getString("ssoAccount");
    QLog.d("SDK_LOGIN.ProxyAuthManager", 1, new Object[] { "ssoAccount: " + (String)localObject1 + ", uin=*" + artw.qx(this.b.uin) + ", timeCost=" + l1, ", isSuccess=", Boolean.valueOf(paramBoolean) });
    if (!this.b.uin.equals(localObject1))
    {
      this.c.a(false, -1, null);
      return;
    }
    int i = paramBundle.getInt("code");
    Object localObject2;
    if (paramBoolean)
    {
      paramInt = 0;
      localObject1 = new auth.AuthResponse();
      localObject2 = localObject1;
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          byte[] arrayOfByte2 = paramBundle.getByteArray("data");
          byte[] arrayOfByte1 = arrayOfByte2;
          localObject2 = localObject1;
          if (this.dcO)
          {
            localObject2 = localObject1;
            arrayOfByte1 = asbp.b(arrayOfByte2, this.b);
          }
          if (arrayOfByte1 == null) {
            break label764;
          }
          localObject2 = localObject1;
          l2 = arrayOfByte1.length;
          localObject2 = localObject1;
          localObject1 = (auth.AuthResponse)((auth.AuthResponse)localObject1).mergeFrom(arrayOfByte1);
          localObject2 = localObject1;
          j = ((auth.AuthResponse)localObject1).ret.get();
          i = j;
        }
        catch (Exception paramBundle)
        {
          long l2;
          int j;
          long l3;
          localObject1 = localObject2;
        }
        try
        {
          localObject2 = ((auth.AuthResponse)localObject1).state.get();
          QLog.d("SDK_LOGIN.ProxyAuthManager", 1, new Object[] { "code=", Integer.valueOf(i), ", respState=", localObject2, ", reqState=", this.cCf });
          if ((i != 0) || (!this.cCf.equals(localObject2))) {
            break label759;
          }
          this.c.a(true, i, arte.a((auth.AuthResponse)localObject1));
          paramInt = 1;
        }
        catch (Exception paramBundle)
        {
          break label601;
          paramInt = 0;
          continue;
        }
        try
        {
          l3 = ((auth.AuthResponse)localObject1).toByteArray().length;
          j = ((auth.AuthResponse)localObject1).ret.get();
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("report_type", "103");
          ((Bundle)localObject2).putString("act_type", "13");
          if (paramBundle.getBoolean("isShort", false))
          {
            paramBundle = "2";
            ((Bundle)localObject2).putString("intext_3", paramBundle);
            ((Bundle)localObject2).putString("stringext_1", this.val$cmd);
            ((Bundle)localObject2).putString("intext_2", "" + j);
            ((Bundle)localObject2).putString("intext_5", "" + l1);
            arts.a().a((Bundle)localObject2, this.cCg, this.b.uin, false, true);
            arxy.a().b("agent_authority", this.Eq, l2, l3, 0, Long.parseLong(this.b.uin), "1000069", "ret: " + j, true);
            aryb.a().b(0, "LOGIN_AUTH", this.b.uin, this.cCg, null, Long.valueOf(SystemClock.elapsedRealtime()), j, 1, null);
            if (paramInt != 0) {
              break;
            }
            this.c.a(false, i, arte.a((auth.AuthResponse)localObject1));
            return;
          }
          paramBundle = "1";
          continue;
          try
          {
            QLog.d("SDK_LOGIN.ProxyAuthManager", 1, "-->success report exception cmd: agent_authority", paramBundle);
          }
          catch (Exception paramBundle)
          {
            break label601;
          }
        }
        catch (Exception paramBundle) {}
      }
      label601:
      this.c.a(false, i, null);
      continue;
      this.c.a(false, i, null);
      try
      {
        arxy.a().b("agent_authority", this.Eq, 0L, 0L, i, Long.parseLong(this.b.uin), "1000069", "", true);
        aryb.a().b(1, "LOGIN_AUTH", this.b.uin, this.cCg, null, Long.valueOf(SystemClock.elapsedRealtime()), 3002, 1, "");
        arts.a().a(this.b.uin, "", this.cCg, "1", "6", "" + 3002, false, true);
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.d("SDK_LOGIN.ProxyAuthManager", 1, "-->failed report exception cmd: agent_authority", paramBundle);
        return;
      }
      label759:
      label764:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arti
 * JD-Core Version:    0.7.0.1
 */