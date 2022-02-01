package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedTreeMap<K, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  private static final Comparator<Comparable> NATURAL_ORDER;
  Comparator<? super K> comparator;
  private LinkedTreeMap<K, V>.EntrySet entrySet;
  final Node<K, V> header = new Node();
  private LinkedTreeMap<K, V>.KeySet keySet;
  int modCount = 0;
  Node<K, V> root;
  int size = 0;
  
  static
  {
    if (!LinkedTreeMap.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      NATURAL_ORDER = new LinkedTreeMap.1();
      return;
    }
  }
  
  public LinkedTreeMap()
  {
    this(NATURAL_ORDER);
  }
  
  public LinkedTreeMap(Comparator<? super K> paramComparator)
  {
    if (paramComparator != null) {}
    for (;;)
    {
      this.comparator = paramComparator;
      return;
      paramComparator = NATURAL_ORDER;
    }
  }
  
  private boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  private void rebalance(Node<K, V> paramNode, boolean paramBoolean)
  {
    Node localNode1;
    Node localNode2;
    int i;
    int j;
    label39:
    int k;
    Node localNode3;
    if (paramNode != null)
    {
      localNode1 = paramNode.left;
      localNode2 = paramNode.right;
      if (localNode1 == null) {
        break label117;
      }
      i = localNode1.height;
      if (localNode2 == null) {
        break label122;
      }
      j = localNode2.height;
      k = i - j;
      if (k != -2) {
        break label172;
      }
      localNode1 = localNode2.left;
      localNode3 = localNode2.right;
      if (localNode3 == null) {
        break label128;
      }
      i = localNode3.height;
      label77:
      if (localNode1 == null) {
        break label133;
      }
      j = localNode1.height;
      label89:
      i = j - i;
      if ((i != -1) && ((i != 0) || (paramBoolean))) {
        break label139;
      }
      rotateLeft(paramNode);
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label242;
      }
      label116:
      return;
      label117:
      i = 0;
      break;
      label122:
      j = 0;
      break label39;
      label128:
      i = 0;
      break label77;
      label133:
      j = 0;
      break label89;
      label139:
      assert (i == 1);
      rotateRight(localNode2);
      rotateLeft(paramNode);
    }
    label172:
    if (k == 2)
    {
      localNode2 = localNode1.left;
      localNode3 = localNode1.right;
      if (localNode3 != null)
      {
        i = localNode3.height;
        label203:
        if (localNode2 == null) {
          break label255;
        }
        j = localNode2.height;
        label215:
        i = j - i;
        if ((i != 1) && ((i != 0) || (paramBoolean))) {
          break label261;
        }
        rotateRight(paramNode);
        label238:
        if (paramBoolean) {
          break label292;
        }
      }
    }
    label242:
    label255:
    do
    {
      do
      {
        paramNode = paramNode.parent;
        break;
        i = 0;
        break label203;
        j = 0;
        break label215;
        assert (i == -1);
        rotateLeft(localNode1);
        rotateRight(paramNode);
        break label238;
        break label116;
        if (k != 0) {
          break label311;
        }
        paramNode.height = (i + 1);
      } while (!paramBoolean);
      return;
      assert ((k == -1) || (k == 1));
      paramNode.height = (Math.max(i, j) + 1);
    } while (paramBoolean);
    label261:
    label292:
    label311:
    return;
  }
  
  private void replaceInParent(Node<K, V> paramNode1, Node<K, V> paramNode2)
  {
    Node localNode = paramNode1.parent;
    paramNode1.parent = null;
    if (paramNode2 != null) {
      paramNode2.parent = localNode;
    }
    if (localNode != null)
    {
      if (localNode.left == paramNode1)
      {
        localNode.left = paramNode2;
        return;
      }
      assert (localNode.right == paramNode1);
      localNode.right = paramNode2;
      return;
    }
    this.root = paramNode2;
  }
  
  private void rotateLeft(Node<K, V> paramNode)
  {
    int k = 0;
    Node localNode1 = paramNode.left;
    Node localNode2 = paramNode.right;
    Node localNode3 = localNode2.left;
    Node localNode4 = localNode2.right;
    paramNode.right = localNode3;
    if (localNode3 != null) {
      localNode3.parent = paramNode;
    }
    replaceInParent(paramNode, localNode2);
    localNode2.left = paramNode;
    paramNode.parent = localNode2;
    int i;
    if (localNode1 != null)
    {
      i = localNode1.height;
      if (localNode3 == null) {
        break label135;
      }
    }
    label135:
    for (int j = localNode3.height;; j = 0)
    {
      paramNode.height = (Math.max(i, j) + 1);
      j = paramNode.height;
      i = k;
      if (localNode4 != null) {
        i = localNode4.height;
      }
      localNode2.height = (Math.max(j, i) + 1);
      return;
      i = 0;
      break;
    }
  }
  
  private void rotateRight(Node<K, V> paramNode)
  {
    int k = 0;
    Node localNode1 = paramNode.left;
    Node localNode2 = paramNode.right;
    Node localNode3 = localNode1.left;
    Node localNode4 = localNode1.right;
    paramNode.left = localNode4;
    if (localNode4 != null) {
      localNode4.parent = paramNode;
    }
    replaceInParent(paramNode, localNode1);
    localNode1.right = paramNode;
    paramNode.parent = localNode1;
    int i;
    if (localNode2 != null)
    {
      i = localNode2.height;
      if (localNode4 == null) {
        break label135;
      }
    }
    label135:
    for (int j = localNode4.height;; j = 0)
    {
      paramNode.height = (Math.max(i, j) + 1);
      j = paramNode.height;
      i = k;
      if (localNode3 != null) {
        i = localNode3.height;
      }
      localNode1.height = (Math.max(j, i) + 1);
      return;
      i = 0;
      break;
    }
  }
  
  private Object writeReplace()
    throws ObjectStreamException
  {
    return new LinkedHashMap(this);
  }
  
  public void clear()
  {
    this.root = null;
    this.size = 0;
    this.modCount += 1;
    Node localNode = this.header;
    localNode.prev = localNode;
    localNode.next = localNode;
  }
  
  public boolean containsKey(Object paramObject)
  {
    return findByObject(paramObject) != null;
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    EntrySet localEntrySet = this.entrySet;
    if (localEntrySet != null) {
      return localEntrySet;
    }
    localEntrySet = new EntrySet();
    this.entrySet = localEntrySet;
    return localEntrySet;
  }
  
  Node<K, V> find(K paramK, boolean paramBoolean)
  {
    Object localObject3 = null;
    Comparator localComparator = this.comparator;
    Object localObject1 = this.root;
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      Comparable localComparable;
      if (localComparator == NATURAL_ORDER)
      {
        localComparable = (Comparable)paramK;
        if (localComparable == null) {
          break label69;
        }
      }
      label60:
      label69:
      for (i = localComparable.compareTo(((Node)localObject1).key);; i = localComparator.compare(paramK, ((Node)localObject1).key))
      {
        if (i != 0) {
          break label86;
        }
        localObject2 = localObject1;
        return localObject2;
        localComparable = null;
        break;
      }
      label86:
      if (i < 0)
      {
        localObject2 = ((Node)localObject1).left;
        label97:
        if (localObject2 != null) {
          break label179;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject3;
      if (!paramBoolean) {
        break label60;
      }
      localObject2 = this.header;
      if (localObject1 == null)
      {
        if ((localComparator == NATURAL_ORDER) && (!(paramK instanceof Comparable)))
        {
          throw new ClassCastException(paramK.getClass().getName() + " is not Comparable");
          localObject2 = ((Node)localObject1).right;
          break label97;
          label179:
          localObject1 = localObject2;
          break;
        }
        paramK = new Node((Node)localObject1, paramK, (Node)localObject2, ((Node)localObject2).prev);
        this.root = paramK;
        this.size += 1;
        this.modCount += 1;
        return paramK;
      }
      paramK = new Node((Node)localObject1, paramK, (Node)localObject2, ((Node)localObject2).prev);
      if (i < 0) {
        ((Node)localObject1).left = paramK;
      }
      for (;;)
      {
        rebalance((Node)localObject1, true);
        break;
        ((Node)localObject1).right = paramK;
      }
      i = 0;
    }
  }
  
  Node<K, V> findByEntry(Map.Entry<?, ?> paramEntry)
  {
    Node localNode = findByObject(paramEntry.getKey());
    if ((localNode != null) && (equal(localNode.value, paramEntry.getValue()))) {}
    for (int i = 1; i != 0; i = 0) {
      return localNode;
    }
    return null;
  }
  
  Node<K, V> findByObject(Object paramObject)
  {
    Node localNode = null;
    if (paramObject != null) {}
    try
    {
      localNode = find(paramObject, false);
      return localNode;
    }
    catch (ClassCastException paramObject) {}
    return null;
  }
  
  public V get(Object paramObject)
  {
    paramObject = findByObject(paramObject);
    if (paramObject != null) {
      return paramObject.value;
    }
    return null;
  }
  
  public Set<K> keySet()
  {
    KeySet localKeySet = this.keySet;
    if (localKeySet != null) {
      return localKeySet;
    }
    localKeySet = new KeySet();
    this.keySet = localKeySet;
    return localKeySet;
  }
  
  public V put(K paramK, V paramV)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    paramK = find(paramK, true);
    Object localObject = paramK.value;
    paramK.value = paramV;
    return localObject;
  }
  
  public V remove(Object paramObject)
  {
    paramObject = removeInternalByKey(paramObject);
    if (paramObject != null) {
      return paramObject.value;
    }
    return null;
  }
  
  void removeInternal(Node<K, V> paramNode, boolean paramBoolean)
  {
    int j = 0;
    if (paramBoolean)
    {
      paramNode.prev.next = paramNode.next;
      paramNode.next.prev = paramNode.prev;
    }
    Node localNode1 = paramNode.left;
    Node localNode2 = paramNode.right;
    Node localNode3 = paramNode.parent;
    int i;
    if ((localNode1 != null) && (localNode2 != null)) {
      if (localNode1.height > localNode2.height)
      {
        localNode1 = localNode1.last();
        removeInternal(localNode1, false);
        localNode2 = paramNode.left;
        if (localNode2 == null) {
          break label262;
        }
        i = localNode2.height;
        localNode1.left = localNode2;
        localNode2.parent = localNode1;
        paramNode.left = null;
      }
    }
    for (;;)
    {
      localNode2 = paramNode.right;
      if (localNode2 != null)
      {
        j = localNode2.height;
        localNode1.right = localNode2;
        localNode2.parent = localNode1;
        paramNode.right = null;
      }
      localNode1.height = (Math.max(i, j) + 1);
      replaceInParent(paramNode, localNode1);
      return;
      localNode1 = localNode2.first();
      break;
      if (localNode1 != null)
      {
        replaceInParent(paramNode, localNode1);
        paramNode.left = null;
      }
      for (;;)
      {
        rebalance(localNode3, false);
        this.size -= 1;
        this.modCount += 1;
        return;
        if (localNode2 != null)
        {
          replaceInParent(paramNode, localNode2);
          paramNode.right = null;
        }
        else
        {
          replaceInParent(paramNode, null);
        }
      }
      label262:
      i = 0;
    }
  }
  
  Node<K, V> removeInternalByKey(Object paramObject)
  {
    paramObject = findByObject(paramObject);
    if (paramObject != null) {
      removeInternal(paramObject, true);
    }
    return paramObject;
  }
  
  public int size()
  {
    return this.size;
  }
  
  class EntrySet
    extends AbstractSet<Map.Entry<K, V>>
  {
    EntrySet() {}
    
    public void clear()
    {
      LinkedTreeMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return ((paramObject instanceof Map.Entry)) && (LinkedTreeMap.this.findByEntry((Map.Entry)paramObject) != null);
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new LinkedTreeMap.EntrySet.1(this);
    }
    
    public boolean remove(Object paramObject)
    {
      if (!(paramObject instanceof Map.Entry)) {}
      do
      {
        return false;
        paramObject = LinkedTreeMap.this.findByEntry((Map.Entry)paramObject);
      } while (paramObject == null);
      LinkedTreeMap.this.removeInternal(paramObject, true);
      return true;
    }
    
    public int size()
    {
      return LinkedTreeMap.this.size;
    }
  }
  
  final class KeySet
    extends AbstractSet<K>
  {
    KeySet() {}
    
    public void clear()
    {
      LinkedTreeMap.this.clear();
    }
    
    public boolean contains(Object paramObject)
    {
      return LinkedTreeMap.this.containsKey(paramObject);
    }
    
    public Iterator<K> iterator()
    {
      return new LinkedTreeMap.KeySet.1(this);
    }
    
    public boolean remove(Object paramObject)
    {
      return LinkedTreeMap.this.removeInternalByKey(paramObject) != null;
    }
    
    public int size()
    {
      return LinkedTreeMap.this.size;
    }
  }
  
  abstract class LinkedTreeMapIterator<T>
    implements Iterator<T>
  {
    int expectedModCount = LinkedTreeMap.this.modCount;
    LinkedTreeMap.Node<K, V> lastReturned = null;
    LinkedTreeMap.Node<K, V> next = LinkedTreeMap.this.header.next;
    
    LinkedTreeMapIterator() {}
    
    public final boolean hasNext()
    {
      return this.next != LinkedTreeMap.this.header;
    }
    
    final LinkedTreeMap.Node<K, V> nextNode()
    {
      LinkedTreeMap.Node localNode = this.next;
      if (localNode == LinkedTreeMap.this.header) {
        throw new NoSuchElementException();
      }
      if (LinkedTreeMap.this.modCount != this.expectedModCount) {
        throw new ConcurrentModificationException();
      }
      this.next = localNode.next;
      this.lastReturned = localNode;
      return localNode;
    }
    
    public final void remove()
    {
      if (this.lastReturned == null) {
        throw new IllegalStateException();
      }
      LinkedTreeMap.this.removeInternal(this.lastReturned, true);
      this.lastReturned = null;
      this.expectedModCount = LinkedTreeMap.this.modCount;
    }
  }
  
  static final class Node<K, V>
    implements Map.Entry<K, V>
  {
    int height;
    final K key;
    Node<K, V> left;
    Node<K, V> next;
    Node<K, V> parent;
    Node<K, V> prev;
    Node<K, V> right;
    V value;
    
    Node()
    {
      this.key = null;
      this.prev = this;
      this.next = this;
    }
    
    Node(Node<K, V> paramNode1, K paramK, Node<K, V> paramNode2, Node<K, V> paramNode3)
    {
      this.parent = paramNode1;
      this.key = paramK;
      this.height = 1;
      this.next = paramNode2;
      this.prev = paramNode3;
      paramNode3.next = this;
      paramNode2.prev = this;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof Map.Entry))
      {
        paramObject = (Map.Entry)paramObject;
        if (this.key != null) {
          break label56;
        }
        bool1 = bool2;
        if (paramObject.getKey() == null)
        {
          if (this.value != null) {
            break label77;
          }
          bool1 = bool2;
          if (paramObject.getValue() != null) {}
        }
      }
      for (;;)
      {
        bool1 = true;
        label56:
        label77:
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!this.key.equals(paramObject.getKey()));
          break;
          bool1 = bool2;
        } while (!this.value.equals(paramObject.getValue()));
      }
    }
    
    public Node<K, V> first()
    {
      Object localObject1 = this.left;
      Object localObject2 = this;
      while (localObject1 != null)
      {
        Node localNode = ((Node)localObject1).left;
        localObject2 = localObject1;
        localObject1 = localNode;
      }
      return localObject2;
    }
    
    public K getKey()
    {
      return this.key;
    }
    
    public V getValue()
    {
      return this.value;
    }
    
    public int hashCode()
    {
      int j = 0;
      int i;
      if (this.key == null)
      {
        i = 0;
        if (this.value != null) {
          break label33;
        }
      }
      for (;;)
      {
        return i ^ j;
        i = this.key.hashCode();
        break;
        label33:
        j = this.value.hashCode();
      }
    }
    
    public Node<K, V> last()
    {
      Object localObject1 = this.right;
      Object localObject2 = this;
      while (localObject1 != null)
      {
        Node localNode = ((Node)localObject1).right;
        localObject2 = localObject1;
        localObject1 = localNode;
      }
      return localObject2;
    }
    
    public V setValue(V paramV)
    {
      Object localObject = this.value;
      this.value = paramV;
      return localObject;
    }
    
    public String toString()
    {
      return this.key + "=" + this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.gson.internal.LinkedTreeMap
 * JD-Core Version:    0.7.0.1
 */