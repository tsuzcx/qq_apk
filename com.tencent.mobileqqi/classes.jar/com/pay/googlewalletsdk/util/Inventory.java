package com.pay.googlewalletsdk.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Inventory
{
  public Map<String, Purchase> mPurchaseMap = new HashMap();
  public Map<String, SkuDetails> mSkuMap = new HashMap();
  
  void addPurchase(Purchase paramPurchase)
  {
    this.mPurchaseMap.put(paramPurchase.getSku(), paramPurchase);
  }
  
  void addSkuDetails(SkuDetails paramSkuDetails)
  {
    this.mSkuMap.put(paramSkuDetails.getSku(), paramSkuDetails);
  }
  
  public void erasePurchase(String paramString)
  {
    if (this.mPurchaseMap.containsKey(paramString)) {
      this.mPurchaseMap.remove(paramString);
    }
  }
  
  List<String> getAllOwnedSkus()
  {
    return new ArrayList(this.mPurchaseMap.keySet());
  }
  
  List<String> getAllOwnedSkus(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mPurchaseMap.values().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      Purchase localPurchase = (Purchase)localIterator.next();
      if (localPurchase.getItemType().equals(paramString)) {
        localArrayList.add(localPurchase.getSku());
      }
    }
  }
  
  List<Purchase> getAllPurchases()
  {
    return new ArrayList(this.mPurchaseMap.values());
  }
  
  public Purchase getPurchase(String paramString)
  {
    return (Purchase)this.mPurchaseMap.get(paramString);
  }
  
  public SkuDetails getSkuDetails(String paramString)
  {
    return (SkuDetails)this.mSkuMap.get(paramString);
  }
  
  public boolean hasDetails(String paramString)
  {
    return this.mSkuMap.containsKey(paramString);
  }
  
  public boolean hasPurchase(String paramString)
  {
    return this.mPurchaseMap.containsKey(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.util.Inventory
 * JD-Core Version:    0.7.0.1
 */