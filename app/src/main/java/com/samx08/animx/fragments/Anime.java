package com.samx08.animx.fragments;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import com.samx08.animx.recyclerview_one.HelperClassOne;
import java.lang.reflect.Member;
import java.util.ArrayList;

import com.samx08.animx.recyclerview_one.RecyclerAdapterOne;
import com.samx08.animx.R;
import com.samx08.animx.model.ImageModel;

public class Anime extends Fragment {

    View view;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;


    ArrayList<HelperClassOne> loaction;

    public Anime() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_anime, container, false);


        recyclerView = view.findViewById(R.id.recycler_one);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false));

        loaction = new ArrayList<>();
        loaction.add(new HelperClassOne(R.drawable.juju,"Jujutsu Kaisen","In a world where demons feed on unsuspecting humans, fragments of the legendary and feared demon Ryoumen Sukuna were lost and scattered about. Should any demon consume Sukuna's body parts, the power they gain could destroy the world as we know it. Fortunately, there exists a mysterious school of Jujutsu Sorcerers who exist to protect the precarious existence of the living from the undead!"));
        loaction.add(new HelperClassOne(R.drawable.golden,"Golden Kamuy Season 3","In Hokkaido, the far northern lands of Japan, Sugimoto survived the Russo-Japanese war of the Meiji era. Nicknamed \"Sugimoto the Immortal\" during the war, he now seeks the riches promised by the gold rush in hopes of saving the widowed wife of his now deceased comrade from the war. During his hunt of gold, he finds hints of a hidden stash of gold by corrupt criminals. Partnering with an Ainu girl that saves his life from the harsh climates of the north, they venture into a survival adventure to race against the criminals that seek the hidden stash.\n"));
        loaction.add(new HelperClassOne(R.drawable.hinata,"Haikyuu!!: To the Top 2nd Season","Thanks to his short height, Hinata struggles to find his role on the team, even with his superior jumping power. Surprisingly, Kageyama has his own problems that only Hinata can help with, and learning to work together appears to be the only way for the team to be successful. Based on Haruichi Furudate's popular shounen manga of the same name, Haikyuu!! is an exhilarating and emotional sports comedy following two determined athletes as they attempt to patch a heated rivalry in order to make their high school volleyball team the best in Japan."));
        loaction.add(new HelperClassOne(R.drawable.dai,"Dragon Quest: Adventure of Dai"," Dai, lives on a remote island in the southern seas and dreams of becoming a great hero. When he hears about the demon's revival, Dai and his friends take it upon themselves to stop him and the evil force that revived him. Along the way, Dai discovers the identity of \"the hero,\" the truth behind the evil force who revived the demon, and Dai's own hidden powers that surface in times of peril."));
        loaction.add(new HelperClassOne(R.drawable.nasakun,"TONIKAWA: Over the Moon For You","After recovering from his injuries, Nasa tosses his previous ambitions aside and dedicates his life to finding the girl that captured his heart, yet several years pass to no avail. But one night, when an unexpected visitor comes knocking on his door, Nasa finds himself facing a woman that would forever change his world: his wife."));
        loaction.add(new HelperClassOne(R.drawable.empiral,"Our Last Crusade or the Rise of a New World","A great war has raged for years between the scientifically advanced Empire and Nebulis, the realm of the witches―until the youngest knight ever to receive the title of the Empire's strongest meets the princess of the rival nation. Though they are sworn enemies, the knight is taken by her beauty and dignity, and the princess is moved by his strength and way of life. Will the fighting between them ever be allowed to end?"));
        loaction.add(new HelperClassOne(R.mipmap.cry,"Higurashi: When They Cry – Gou","New kid Keiichi Maebara is settling into his new home of peaceful Hinamizawa village. Making quick friends with the girls from his school, he’s arrived in time for the big festival of the year.\n" +
                "\n" +
                "But something about this isolated town seems \"off,\" and his feelings of dread continue to grow. With a gnawing fear that he’s right, what dark secrets could this small community be hiding?"));
        loaction.add(new HelperClassOne(R.mipmap.noblesse,"Noblesse","Raizel awakens from his 820-year slumber. He holds the special title of Noblesse which is a pure-blooded Noble and protector of all other Nobles. In an attempt to protect Raizel, his servant Frankenstein enrolls him at Ye-Ran High School, where Raizel learn the simple and quotidian routines of the human world through his classmates. However, the Union - a mighty secret organization with strings around the globe and a goal to rule the world - dispatches modified humans and gradually encroaches on Raizel's life progressively - which causes him to wield his mighty power to protect those around him."));
        loaction.add(new HelperClassOne(R.mipmap.standing,"I'm standing on 1,000,000 lives.","Yotsuya Yuusuke along with his classmates Shindou Iu and Hakozaki Kusue have been transported to a strange and unknown world inhabited by mythological creatures. As soon as they arrive, they meet somebody calling himself the Game Master who then grants them a time-limited quest."));
        loaction.add(new HelperClassOne(R.mipmap.misfit,"The Irregular at Magic High School: Visitor Arc","Shiba Miyuki's classmate Kitayama Shizuku is on her way to study abroad. For magicians, this is normally impossible, since allowing the genes of someone who can use magic outside their home country's borders is tantamount to giving up national secrets. But it's allowed to happen in one case-exchange programs. And that's how Angelina Kudou Shields has arrived in Japan from the USNA to study at First High."));
        loaction.add(new HelperClassOne(R.mipmap.god,"The Day I Became a God","At the end of the last summer vacation of high school, Youta Narukami spends his days preparing for the university entrance exams, when a young girl named Hina suddenly appears, proclaiming herself as the \"god of omniscience.\" Youta is confused and does not believe Hina when she tells him \"The world will end in 30 days.\" After witnessing Hina's God-like predictive ability, Youta begins to believe her powers are real. Hina, who is innocent and childlike despite her supernatural powers, decides for some reason to stay at Youta's home. Thus begins the start of their lively summer before the end of the world."));

        adapter = new RecyclerAdapterOne(getContext(),loaction);
        recyclerView.setAdapter(adapter);




        return view;
    }

}

