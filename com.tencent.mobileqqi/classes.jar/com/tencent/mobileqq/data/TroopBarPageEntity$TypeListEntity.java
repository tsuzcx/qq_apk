package com.tencent.mobileqq.data;

import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;

public class TroopBarPageEntity$TypeListEntity
  extends TroopBarAbsDataEntity
{
  protected static final String JSON_KEY_NAME = "name";
  protected static final String JSON_KEY_TYPE = "type";
  protected static final long serialVersionUID = 10002L;
  public String name;
  public int type;
  
  public TroopBarPageEntity$TypeListEntity() {}
  
  public TroopBarPageEntity$TypeListEntity(int paramInt, String paramString)
  {
    this.type = paramInt;
    this.name = paramString;
  }
  
  public TroopBarPageEntity$TypeListEntity(TypeListEntity paramTypeListEntity)
  {
    this(paramTypeListEntity.type, paramTypeListEntity.name);
  }
  
  public TroopBarPageEntity$TypeListEntity(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.name = TroopBarUtils.a(paramJSONObject, "name");
    this.type = TroopBarUtils.a(paramJSONObject, "type");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof TypeListEntity))
    {
      paramObject = (TypeListEntity)paramObject;
      bool1 = bool2;
      if (this.type == paramObject.type) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.name = paramObjectInput.readUTF();
    this.type = paramObjectInput.readInt();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.name);
    paramObjectOutput.writeInt(this.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarPageEntity.TypeListEntity
 * JD-Core Version:    0.7.0.1
 */