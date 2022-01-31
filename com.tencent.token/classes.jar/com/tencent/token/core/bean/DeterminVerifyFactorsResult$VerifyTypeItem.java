package com.tencent.token.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeterminVerifyFactorsResult$VerifyTypeItem
  implements Serializable
{
  private static final long serialVersionUID = 7129591075283836873L;
  private Map factorPositionMap = new HashMap();
  private List mVerifyFactorList = new ArrayList();
  private int verifyTypeId;
  private String verifyTypeName;
  
  public DeterminVerifyFactorsResult$VerifyTypeItem(DeterminVerifyFactorsResult paramDeterminVerifyFactorsResult, JSONObject paramJSONObject)
  {
    this.verifyTypeId = paramJSONObject.getInt("verify_type_id");
    this.verifyTypeName = paramJSONObject.getString("verify_type_name");
    paramDeterminVerifyFactorsResult = paramJSONObject.getJSONArray("verify_factors");
    int i = 0;
    while (i < paramDeterminVerifyFactorsResult.length())
    {
      this.mVerifyFactorList.add(Integer.valueOf(paramDeterminVerifyFactorsResult.getInt(i)));
      this.factorPositionMap.put(Integer.valueOf(paramDeterminVerifyFactorsResult.getInt(i)), Integer.valueOf(i));
      i += 1;
    }
  }
  
  public int a()
  {
    return this.verifyTypeId;
  }
  
  public int a(int paramInt)
  {
    paramInt = ((Integer)this.factorPositionMap.get(Integer.valueOf(paramInt))).intValue();
    if (paramInt < this.mVerifyFactorList.size() - 1) {
      paramInt += 1;
    }
    for (;;)
    {
      return ((Integer)this.mVerifyFactorList.get(paramInt)).intValue();
      paramInt = this.mVerifyFactorList.size() - 1;
    }
  }
  
  public boolean a(Integer paramInteger)
  {
    return ((Integer)this.factorPositionMap.get(paramInteger)).intValue() == this.mVerifyFactorList.size() - 1;
  }
  
  public String b()
  {
    return this.verifyTypeName;
  }
  
  public List c()
  {
    return this.mVerifyFactorList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem
 * JD-Core Version:    0.7.0.1
 */