package com.tencent.mobileqq.data;

import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarUserEntity
  extends TroopBarAbsDataEntity
{
  protected static final String JSON_KEY_ADMIN_EXT = "admin_ext";
  protected static final String JSON_KEY_GENDER = "gender";
  protected static final String JSON_KEY_ICON_LISTS = "icon_list";
  protected static final String JSON_KEY_LEVEL = "level";
  protected static final String JSON_KEY_NICK_NAME = "nick_name";
  public static final int USER_GENDER_MAN = 1;
  public static final int USER_GENDER_UNKNOW = 0;
  public static final int USER_GENDER_WOMAN = 2;
  protected static final long serialVersionUID = 10007L;
  public String admin_ext;
  public int gender;
  public byte[] iconListBytes;
  public int level;
  public String nickName;
  
  public TroopBarUserEntity() {}
  
  public TroopBarUserEntity(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.nickName = TroopBarUtils.a(paramJSONObject, "nick_name");
    this.admin_ext = TroopBarUtils.a(paramJSONObject, "admin_ext");
    this.gender = TroopBarUtils.a(paramJSONObject, "gender");
    this.level = TroopBarUtils.a(paramJSONObject, "level");
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("icon_list");
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(new TroopBarIconFlagEntity(paramJSONObject.getJSONObject(i)));
        i += 1;
      }
      this.iconListBytes = objectToBytes(localArrayList);
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
  
  /* Error */
  public ArrayList getIconListEntitys()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 93	com/tencent/mobileqq/data/TroopBarUserEntity:iconListBytes	[B
    //   4: ifnull +116 -> 120
    //   7: new 103	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 93	com/tencent/mobileqq/data/TroopBarUserEntity:iconListBytes	[B
    //   15: invokespecial 106	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore 4
    //   20: new 108	java/io/ObjectInputStream
    //   23: dup
    //   24: aload 4
    //   26: invokespecial 111	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore 5
    //   31: aload 5
    //   33: invokevirtual 115	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   36: astore_1
    //   37: aload_1
    //   38: instanceof 69
    //   41: ifeq +74 -> 115
    //   44: aload_1
    //   45: checkcast 69	java/util/ArrayList
    //   48: astore_1
    //   49: aload_1
    //   50: astore_2
    //   51: aload_1
    //   52: astore_3
    //   53: aload 4
    //   55: invokevirtual 118	java/io/ByteArrayInputStream:close	()V
    //   58: aload_1
    //   59: astore_2
    //   60: aload_1
    //   61: astore_3
    //   62: aload 5
    //   64: invokevirtual 119	java/io/ObjectInputStream:close	()V
    //   67: aload_1
    //   68: areturn
    //   69: astore 4
    //   71: aconst_null
    //   72: astore_1
    //   73: aload_1
    //   74: astore_2
    //   75: aload_1
    //   76: astore_3
    //   77: aload 4
    //   79: invokevirtual 122	java/lang/ClassNotFoundException:printStackTrace	()V
    //   82: aload_1
    //   83: areturn
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 123	java/io/StreamCorruptedException:printStackTrace	()V
    //   89: aload_2
    //   90: areturn
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_3
    //   94: aload_1
    //   95: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   98: aload_3
    //   99: areturn
    //   100: astore_1
    //   101: goto -7 -> 94
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_2
    //   107: goto -22 -> 85
    //   110: astore 4
    //   112: goto -39 -> 73
    //   115: aconst_null
    //   116: astore_1
    //   117: goto -68 -> 49
    //   120: aconst_null
    //   121: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	TroopBarUserEntity
    //   36	47	1	localObject1	Object
    //   84	2	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   91	4	1	localIOException1	IOException
    //   100	1	1	localIOException2	IOException
    //   104	1	1	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   116	1	1	localObject2	Object
    //   50	57	2	localObject3	Object
    //   52	47	3	localObject4	Object
    //   18	36	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   69	9	4	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   110	1	4	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   29	34	5	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   31	49	69	java/lang/ClassNotFoundException
    //   53	58	84	java/io/StreamCorruptedException
    //   62	67	84	java/io/StreamCorruptedException
    //   77	82	84	java/io/StreamCorruptedException
    //   20	31	91	java/io/IOException
    //   31	49	91	java/io/IOException
    //   53	58	100	java/io/IOException
    //   62	67	100	java/io/IOException
    //   77	82	100	java/io/IOException
    //   20	31	104	java/io/StreamCorruptedException
    //   31	49	104	java/io/StreamCorruptedException
    //   53	58	110	java/lang/ClassNotFoundException
    //   62	67	110	java/lang/ClassNotFoundException
  }
  
  public byte[] objectToBytes(Object paramObject)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      localObjectOutputStream.flush();
      paramObject = localByteArrayOutputStream.toByteArray();
      return paramObject;
    }
    catch (IOException paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.nickName = paramObjectInput.readUTF();
    this.admin_ext = paramObjectInput.readUTF();
    this.gender = paramObjectInput.readInt();
    this.level = paramObjectInput.readInt();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.nickName);
    paramObjectOutput.writeUTF(this.admin_ext);
    paramObjectOutput.writeInt(this.gender);
    paramObjectOutput.writeInt(this.level);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarUserEntity
 * JD-Core Version:    0.7.0.1
 */