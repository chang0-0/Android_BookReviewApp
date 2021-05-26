package org.techtown.BookReviewApp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    int count = 1;
    ArrayList<Book> items = new ArrayList<Book>();
    private OnItemClickListener Listener = null;

    public interface OnItemClickListener {
        void onItemClick(View v, int pos, String title, String author, String inside);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.Listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;

        ViewHolder(final View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.title);
            textView2 = itemView.findViewById(R.id.author);
            textView3 = itemView.findViewById(R.id.countView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    String title = null, author = null, inside = null;

                    /*제목, 저자, 내용들을 pos의 숫자에 따라 받아낸다음
                    리사이클러뷰에 따라 정해진 내용으로 완성됨*/

                    if(pos != RecyclerView.NO_POSITION){
                        if(Listener != null) {
                            Listener.onItemClick(v,pos,title,author,inside);
                        }
                    }
                }
            });
        }
    }

    public BookAdapter(ArrayList<Book> list) {
        items = list;
    }

    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.recy_activity, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView1.setText(items.get(position).getTitle());
        holder.textView2.setText(items.get(position).getAuthor());
        //holder.textView2.setText(String.valueOf(items.get(position).getAuthor()));
        holder.textView3.setText("#" + count++);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
