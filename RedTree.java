package suanfaTest;

public class RedTree {
	Node[] TreeList=new Node[100];
	int i=1;
	public void Insert(Node v){
		if(TreeList==null){
			TreeList[1]=v;
			i++;
		}
		else{
			SearchTree(TreeList[1],v);
		}
	}
	
	public void Delect(Node v){
		for(int j=1;j<=i;j++){
			if(TreeList[j]!=null){
		if(((TreeList[j].vertex1==v.vertex1)||(TreeList[j].vertex1==v.vertex2))&&
				((TreeList[j].vertex2==v.vertex1)||(TreeList[j].vertex2==v.vertex2))){
			if(TreeList[j].parent!=null){
				if(TreeList[j].parent.leftson==TreeList[j]){				
					if(TreeList[j].rightson!=null){
						TreeList[j].parent.leftson=TreeList[j].rightson;	
						//�������ô����
					}
					else if(TreeList[j].leftson!=null){
						TreeList[j].parent.leftson=TreeList[j].leftson;
						//�Ҷ�����ô����
					}
				}
				else
				{
					if(TreeList[j].rightson!=null){
						TreeList[j].parent.rightson=TreeList[j].rightson;	
						//�������ô����
					}
					else if(TreeList[j].leftson!=null){
						TreeList[j].parent.rightson=TreeList[j].leftson;
						//�Ҷ�����ô����
					}
				}
			}						
			TreeList[j]=null;
			//������,��Ҫ������ʽ�����ݽṹ��������ӣ�ɾ��
			
		}
			}
		}
	}
	
	public void SearchTree(Node treehead,Node v){	
			if(Computational_geometry.Cross_product(v.vertex1, treehead.vertex1)>0){
				if(treehead.leftson==null){
					treehead.leftson=v;
					v.parent=treehead;
					TreeList[i]=v;
					i++;
				}
				else
				{SearchTree(treehead.leftson,v);}
			}
			else{
				if(treehead.rightson==null){
					treehead.rightson=v;
					v.parent=treehead;
					TreeList[i]=v;
					i++;
				}
				else
				{SearchTree(treehead.rightson,v);}
			}
	}
	
	public void ListTree(){
		
	}
	
}


class Node{
	String color;
	Vertex vertex1=new Vertex();//��ʼ��
	Vertex vertex2=new Vertex();//������
    Node leftson;
    Node rightson;
    Node parent;
}