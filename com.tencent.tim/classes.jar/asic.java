import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qidian.proto.mobileqq_qidian.PubAccItem;

public class asic
{
  public String cEP = "";
  public String faceUrl = "";
  public boolean isChecked;
  public String name = "";
  public int type;
  public String uin = "";
  public int verity;
  
  public asic() {}
  
  public asic(mobileqq_qidian.PubAccItem paramPubAccItem)
  {
    a(paramPubAccItem);
  }
  
  public mobileqq_qidian.PubAccItem a()
  {
    mobileqq_qidian.PubAccItem localPubAccItem = new mobileqq_qidian.PubAccItem();
    localPubAccItem.str_uin.set(this.uin);
    localPubAccItem.str_name.set(this.name);
    localPubAccItem.uint32_type.set(this.type);
    localPubAccItem.uint32_verity.set(this.verity);
    localPubAccItem.str_face_url.set(this.faceUrl);
    localPubAccItem.str_qr_url.set(this.cEP);
    return localPubAccItem;
  }
  
  public void a(mobileqq_qidian.PubAccItem paramPubAccItem)
  {
    if (paramPubAccItem.str_uin.has()) {
      this.uin = paramPubAccItem.str_uin.get();
    }
    if (paramPubAccItem.str_name.has()) {
      this.name = paramPubAccItem.str_name.get();
    }
    if (paramPubAccItem.uint32_type.has()) {
      this.type = paramPubAccItem.uint32_type.get();
    }
    if (paramPubAccItem.uint32_verity.has()) {
      this.verity = paramPubAccItem.uint32_verity.get();
    }
    if (paramPubAccItem.str_face_url.has()) {
      this.faceUrl = paramPubAccItem.str_face_url.get();
    }
    if (paramPubAccItem.str_qr_url.has()) {
      this.cEP = paramPubAccItem.str_qr_url.get();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (paramObject.getClass() != getClass());
    paramObject = (asic)paramObject;
    if ((paramObject.uin.equals(this.uin)) && (paramObject.name.equals(this.name)) && (paramObject.type == this.type) && (paramObject.verity == this.verity) && (paramObject.faceUrl.equals(this.faceUrl)) && (paramObject.cEP.equals(this.cEP))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int hashCode()
  {
    int j = this.uin.hashCode();
    int k = this.name.hashCode();
    int m = this.type;
    int n = this.verity;
    if (this.isChecked) {}
    for (int i = 0;; i = 1) {
      return ((i + ((((j + 403) * 31 + k) * 31 + m) * 31 + n) * 31) * 31 + this.faceUrl.hashCode()) * 31 + this.cEP.hashCode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asic
 * JD-Core Version:    0.7.0.1
 */