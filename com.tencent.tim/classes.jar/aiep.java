import com.tencent.biz.huiyin.ILiveProto.iLiveRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huiyin.proto.FalcoLoginProto.LoginCheckReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class aiep
  implements aica.b
{
  aiep(aien paramaien, AppInterface paramAppInterface) {}
  
  public void l(String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("huiyin", 2, "get key finish " + paramBoolean + ", " + paramInt);
    }
    if (paramBoolean)
    {
      aien.a(this.this$0).opType("huiyin").opName("login").report();
      paramString = new ILiveProto.iLiveRequest();
      paramString.auth_appid.set(101462571L);
      paramString.auth_type.set(1);
      paramString.cmd.set(65536);
      paramString.subcmd.set(1);
      paramString.original_id.set(ByteStringMicro.copyFrom(this.this$0.b.a().mOpenID.getBytes()));
      paramString.original_id_type.set(1);
      paramString.original_key.set(ByteStringMicro.copyFrom(this.this$0.b.a().mAccessToken.getBytes()));
      paramString.original_key_type.set(1);
      paramString.original_auth_appid.set(101462571L);
      paramString.client_type.set(401);
      paramString.buss_id.set(160000001L);
      Object localObject = new FalcoLoginProto.LoginCheckReq();
      ((FalcoLoginProto.LoginCheckReq)localObject).refresh.set(false);
      ((FalcoLoginProto.LoginCheckReq)localObject).is_test.set(aien.b(this.this$0));
      paramString.ex.set(ByteStringMicro.copyFrom(((FalcoLoginProto.LoginCheckReq)localObject).toByteArray()));
      localObject = new NewIntent(this.val$appInterface.getApplication(), jnl.class);
      ((NewIntent)localObject).putExtra("cmd", aien.a(this.this$0) + ".0x10000_0x1");
      ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
      ((NewIntent)localObject).setObserver(new aieq(this));
      this.val$appInterface.startServlet((NewIntent)localObject);
      return;
    }
    QLog.e("huiyin", 1, "get token error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiep
 * JD-Core Version:    0.7.0.1
 */