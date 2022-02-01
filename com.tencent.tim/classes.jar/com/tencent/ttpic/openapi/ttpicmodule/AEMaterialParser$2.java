package com.tencent.ttpic.openapi.ttpicmodule;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.tencent.ttpic.baseutils.report.ReportUtil;

class AEMaterialParser$2
  implements Runnable
{
  AEMaterialParser$2(AEMaterialParser paramAEMaterialParser, Context paramContext, String paramString1, String paramString2, Class paramClass, AEMaterialParser.ParseCallback paramParseCallback) {}
  
  public void run()
  {
    Object localObject1 = AEMaterialParser.access$100(this.this$0, this.val$context, this.val$path, this.val$filename, AEMaterialParser.access$000());
    if (TextUtils.isEmpty(this.val$path)) {
      throw new IllegalArgumentException("template json is not valid");
    }
    Gson localGson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    try
    {
      localObject1 = localGson.fromJson((String)localObject1, this.val$materialExtClass);
      if ((localObject1 != null) && (this.val$parseCallback != null)) {
        this.val$parseCallback.onSuccess(localObject1);
      }
      return;
    }
    catch (JsonSyntaxException localJsonSyntaxException)
    {
      for (;;)
      {
        ReportUtil.report("template parse error!" + localJsonSyntaxException);
        localJsonSyntaxException.printStackTrace();
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.AEMaterialParser.2
 * JD-Core Version:    0.7.0.1
 */