package vn.edu.ntu.nhatduy.contacttest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.CheckedOutputStream;

import vn.edu.ntu.nhatduy.controller.IContactController;
import vn.edu.ntu.nhatduy.model.Contact;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvContact;
    ContactAdapter adapter;
    List<Contact> listContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
    }

    private void addViews(){
        rvContact = findViewById(R.id.rvContact);
        rvContact.setLayoutManager(new LinearLayoutManager(this));
        IContactController contactController = (IContactController) getApplication();
        listContacts = contactController.getAllContact();
        adapter = new ContactAdapter(listContacts);
        rvContact.setAdapter(adapter);
    }

    private class ContactViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtDate, txtSDT;
        ImageView imgNote;
        Contact c;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = this.itemView.findViewById(R.id.txtName);
            txtDate = this.itemView.findViewById(R.id.txtDate);
            txtSDT = this.itemView.findViewById(R.id.txtSDT);
            imgNote = this.itemView.findViewById(R.id.imgNote);
        }

        public void bind (Contact c){
            this.c = c;
            txtName.setText(c.getName());
            txtDate.setText(c.getDate());
            txtSDT.setText(c.getSdt());
        }
    }

    private class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder>{
        List<Contact> listContacts;

        public ContactAdapter(List<Contact> listContacts) {
            this.listContacts = listContacts;
        }

        @NonNull
        @Override
        public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.contact, parent, false);
            return new ContactViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
            holder.bind(listContacts.get(position));
        }

        @Override
        public int getItemCount() {
            return listContacts.size();
        }
    }
}
