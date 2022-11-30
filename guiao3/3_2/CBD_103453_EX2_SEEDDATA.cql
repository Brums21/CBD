-- insert into table users
INSERT INTO users (username, email, name, time_regist) VALUES ('Eleen Lehmann', 'Lehmann', 'elehmann0@bloglines.com', '2021-12-22T15:34:00Z' );
INSERT INTO users (username, email, name, time_regist) VALUES ('Jerald Sheddan', 'Sheddan', 'jsheddan1@mail.ru', '2020-09-14T16:10:29Z' );
INSERT INTO users (username, email, name, time_regist) VALUES ('Wilt Elsip', 'Elsip', 'welsip2@feedburner.com', '2020-10-10T19:39:42Z' );
INSERT INTO users (username, email, name, time_regist) VALUES ('Oran Timpany', 'Timpany', 'otimpany3@istockphoto.com', '2020-06-21T12:13:56Z' );
INSERT INTO users (username, email, name, time_regist) VALUES ('Ogdan Bremmer', 'Bremmer', 'obremmer4@gov.uk', '2021-01-09T19:32:16Z' );
INSERT INTO users (username, email, name, time_regist) VALUES ('Filip Fiddeman', 'Fiddeman', 'ffiddeman5@zimbio.com', '2020-12-07T02:30:59Z' );
INSERT INTO users (username, email, name, time_regist) VALUES ('Stoddard Amys', 'Amys', 'samys6@t-online.de', '2020-08-23T04:02:50Z' );
INSERT INTO users (username, email, name, time_regist) VALUES ('Dael Pallent', 'Pallent', 'dpallent7@histats.com', '2020-08-21T22:47:34Z' );
INSERT INTO users (username, email, name, time_regist) VALUES ('Melissa Tribbeck', 'Tribbeck', 'mtribbeck8@shareasale.com', '2021-08-28T18:20:14Z' );
INSERT INTO users (username, email, name, time_regist) VALUES ('Urson Mottley', 'Mottley', 'umottley9@freewebs.com', '2020-12-10T12:12:05Z' );
INSERT INTO users (username, email, name, time_regist) VALUES ('Tracey Rosenblath', 'Rosenblath', 'trosenblatha@mediafire.com', '2020-08-05T07:29:34Z' );
INSERT INTO users (username, email, name, time_regist) VALUES ('Ashly Nesterov', 'Nesterov', 'anesterovb@loc.gov', '2021-07-16T10:28:22Z' );
INSERT INTO users (username, email, name, time_regist) VALUES ('Townsend Bernardino', 'Bernardino', 'tbernardinoc@hubpages.com', '2021-11-12T19:53:37Z' );
INSERT INTO users (username, email, name, time_regist) VALUES ('Berky Stentiford', 'Stentiford', 'bstentifordd@uol.com.br', '2020-12-17T07:28:01Z' );
INSERT INTO users (username, email, name, time_regist) VALUES ('Gwenette Gilfoy', 'Gilfoy', 'ggilfoye@shareasale.com', '2021-05-03T13:36:27Z' );

-- insert into table videos
INSERT INTO videos (author, name, description, tags, uploads) VALUES ('Thomas Eddison', 'Daily Dose of Internet', 'Compilation of best moments', ['compilation', 'funny'], '2022-03-15T15:46:53Z');
INSERT INTO videos (author, name, description, tags, uploads) VALUES ('Urson Mottley', 'Best recipes', 'Here is a description of some of my best recipes', ['food', 'recipes'], '2021-05-12T16:23:13Z');
INSERT INTO videos (author, name, description, tags, uploads) VALUES ('Carlo Montana', 'Outfits 2022', 'Here are my best outfits for 2022', ['style'], '2021-07-13T14:11:03Z');
INSERT INTO videos (author, name, description, tags, uploads) VALUES ('Stoddard Amys', 'Sad Song', 'New album released!', ['music', 'album'], '2020-08-25T12:28:50Z');
INSERT INTO videos (author, name, description, tags, uploads) VALUES ('Amyll Hamme', 'My pets', 'Me and my pets', ['animals'], '2021-07-30T04:11:42Z');
INSERT INTO videos (author, name, description, tags, uploads) VALUES ('Ogdan Bremmer', 'Tennis Championship finals compilations', 'Tennis Championship 2021 best moments', ['sports', 'tennis'], '2021-05-12T16:23:13Z');
INSERT INTO videos (author, name, description, tags, uploads) VALUES ('Vanessa Hudins', 'First flood in 53 years', 'First flood in Florida in 53 years caughts everyone off guard', ['disasters', 'news'], '2022-01-12T06:33:01Z');
INSERT INTO videos (author, name, description, tags, uploads) VALUES ('Clarissa Megan', 'Latest news today', 'Latest news in Honolulu this month', ['news'], '2021-02-24T14:06:41Z');
INSERT INTO videos (author, name, description, tags, uploads) VALUES ('Berky Stentiford', 'Water Bucket Challenge', 'I face the water bucket challenge - all money goes to Save the Children charity!', ['challenge', 'charity'], '2022-10-23T09:47:23Z');
INSERT INTO videos (author, name, description, tags, uploads) VALUES ('Dael Pallent', 'Best Tips for studying', 'These are my best techniques to gain focus', ['study'], '2021-12-20T18:48:53Z');
INSERT INTO videos (author, name, description, tags, uploads) VALUES ('Mark Frank', 'League of Guardias Latest Update', 'RIMO has nerfed some Guardians, new patch incoming', ['LoG', 'gaming'], '2022-07-06T18:36:58Z');
INSERT INTO videos (author, name, description, tags, uploads) VALUES ('Aleph Paimon', 'no thoughs, head empty', 'Just vibes', [], '2021-05-12T23:23:09Z');

-- insert into table events:
INSERT INTO events (video_author, video_name, username, type, time, datetime) VALUES ('Thomas Eddison', 'Daily Dose of Internet', 'Bremmer', 'pause', '120', '2022-11-03T18:36:58Z');
INSERT INTO events (video_author, video_name, username, type, time, datetime) VALUES ('Urson Mottley', 'Best recipes', 'Mottley', 'play', '200', '2022-10-25T15:16:31Z');
INSERT INTO events (video_author, video_name, username, type, time, datetime) VALUES ('Stoddard Amys', 'Sad Song', 'Bremmer', 'stop', '10', '2022-11-28T10:26:17Z');
INSERT INTO events (video_author, video_name, username, type, time, datetime) VALUES ('Stoddard Amys', 'Sad Song', 'Nesterov', 'pause', '3', '2022-10-30T05:56:18Z');
INSERT INTO events (video_author, video_name, username, type, time, datetime) VALUES ('Ogdan Bremmer', 'Tennis Championship finals compilations', 'Elsip', 'stop', '130', '2022-05-01T15:14:31Z');
INSERT INTO events (video_author, video_name, username, type, time, datetime) VALUES ('Vanessa Hudins', 'First flood in 53 years', 'Nesterov', 'play', '123', '2022-10-28T10:13:42Z');
INSERT INTO events (video_author, video_name, username, type, time, datetime) VALUES ('Vanessa Hudins', 'First flood in 53 years', 'Mottley', 'pause', '234', '2022-10-30T14:22:18Z');
INSERT INTO events (video_author, video_name, username, type, time, datetime) VALUES ('Vanessa Hudins', 'First flood in 53 years', 'Bremmer', 'stop', '220', '2022-10-31T20:43:16Z');
INSERT INTO events (video_author, video_name, username, type, time, datetime) VALUES ('Berky Stentiford', 'Water Bucket Challenge', 'Nesterov', 'stop', '110', '2022-11-17T15:22:17Z');
INSERT INTO events (video_author, video_name, username, type, time, datetime) VALUES ('Dael Pallent', 'Best Tips for studying', 'Nesterov', 'play', '50', '2022-11-26T13:13:13Z');
INSERT INTO events (video_author, video_name, username, type, time, datetime) VALUES ('Dael Pallent', 'Best Tips for studying', 'Elsip', 'pause', '37', '2022-10-13T14:32:12Z');
INSERT INTO events (video_author, video_name, username, type, time, datetime) VALUES ('Urson Mottley', 'Best recipes', 'Elsip', 'pause', '105', '2022-10-12T08:46:01Z');
INSERT INTO events (video_author, video_name, username, type, time, datetime) VALUES ('Urson Mottley', 'Best recipes', 'Mottley', 'play', '205', '2022-07-06T18:36:58Z');
INSERT INTO events (video_author, video_name, username, type, time, datetime) VALUES ('Aleph Paimon', 'no thoughs, head empty', 'Elsip', 'stop', '173', '2022-11-03T14:11:15Z');

-- insert into table followers  
INSERT INTO followers (username, video_author, video_name) VALUES ('Bremmer', 'Thomas Eddison', 'Daily Dose of Internet');
INSERT INTO followers (username, video_author, video_name) VALUES ('Tribbeck', 'Thomas Eddison', 'Daily Dose of Internet');
INSERT INTO followers (username, video_author, video_name) VALUES ('Amys', 'Thomas Eddison', 'Daily Dose of Internet');
INSERT INTO followers (username, video_author, video_name) VALUES ('Bremmer', 'Stoddard Amys', 'Sad Song');
INSERT INTO followers (username, video_author, video_name) VALUES ('Nesterov', 'Stoddard Amys', 'Sad Song');
INSERT INTO followers (username, video_author, video_name) VALUES ('Tribbeck', 'Clarissa Megan', 'Latest news today');
INSERT INTO followers (username, video_author, video_name) VALUES ('Nesterov', 'Aleph Paimon', 'no thoughs, head empty');
INSERT INTO followers (username, video_author, video_name) VALUES ('Stentiford', 'Aleph Paimon', 'no thoughs, head empty');
INSERT INTO followers (username, video_author, video_name) VALUES ('Tribbeck', 'Aleph Paimon', 'no thoughs, head empty');
INSERT INTO followers (username, video_author, video_name) VALUES ('Amys', 'Aleph Paimon', 'no thoughs, head empty');
INSERT INTO followers (username, video_author, video_name) VALUES ('Stentiford', 'Mark Frank', 'League of Guardias Latest Update');
INSERT INTO followers (username, video_author, video_name) VALUES ('Timpany', 'Mark Frank', 'League of Guardias Latest Update');
INSERT INTO followers (username, video_author, video_name) VALUES ('Amys', 'Clarissa Megan', 'Latest news today');
INSERT INTO followers (username, video_author, video_name) VALUES ('Nesterov', 'Clarissa Megan', 'Latest news today');
INSERT INTO followers (username, video_author, video_name) VALUES ('Stentiford', 'Clarissa Megan', 'Latest news today');

-- insert into table rating
INSERT INTO rating (video_author, video_name, score, author) VALUES ('Thomas Eddison', 'Daily Dose of Internet', 3, 'Beth');
INSERT INTO rating (video_author, video_name, score, author) VALUES ('Carlo Montana', 'Outfits 2022', 5, 'Amys');
INSERT INTO rating (video_author, video_name, score, author) VALUES ('Carlo Montana', 'Outfits 2022', 4, 'Tribbeck');
INSERT INTO rating (video_author, video_name, score, author) VALUES ('Vanessa Hudins', 'First flood in 53 years', 4, 'Catherine');
INSERT INTO rating (video_author, video_name, score, author) VALUES ('Vanessa Hudins', 'First flood in 53 years', 5, 'Stentiford');
INSERT INTO rating (video_author, video_name, score, author) VALUES ('Urson Mottley', 'Best recipes', 3, 'Nesterov');
INSERT INTO rating (video_author, video_name, score, author) VALUES ('Urson Mottley', 'Best recipes', 5, 'Cassidy');
INSERT INTO rating (video_author, video_name, score, author) VALUES ('Urson Mottley', 'Best recipes', 4, 'Cain');
INSERT INTO rating (video_author, video_name, score, author) VALUES ('Aleph Paimon', 'no thoughs, head empty', 2, 'Cassandra');
INSERT INTO rating (video_author, video_name, score, author) VALUES ('Aleph Paimon', 'no thoughs, head empty', 5, 'Amelia');
INSERT INTO rating (video_author, video_name, score, author) VALUES ('Aleph Paimon', 'no thoughs, head empty', 5, 'Monica');
INSERT INTO rating (video_author, video_name, score, author) VALUES ('Berky Stentiford', 'Water Bucket Challenge', 4, 'Bremmer');
INSERT INTO rating (video_author, video_name, score, author) VALUES ('Berky Stentiford', 'Water Bucket Challenge', 4, 'Beth');
INSERT INTO rating (video_author, video_name, score, author) VALUES ('Berky Stentiford', 'Water Bucket Challenge', 5, 'Anna');

-- insert into table comments
INSERT INTO comments (video_author, video, comment, time, author) VALUES ('Aleph Paimon', 'no thoughs, head empty', 'Good vibes' ,'2022-10-17T15:22:17Z', 'Elsip');
INSERT INTO comments (video_author, video, comment, time, author) VALUES ('Aleph Paimon', 'no thoughs, head empty', 'Nice song' ,'2022-11-17T15:23:10Z', 'Fiddeman');
INSERT INTO comments (video_author, video, comment, time, author) VALUES ('Urson Mottley', 'Best recipes', 'Delicious' ,'2022-10-30T10:44:18Z', 'Stentiford');
INSERT INTO comments (video_author, video, comment, time, author) VALUES ('Urson Mottley', 'Best recipes', 'Have to try' ,'2022-11-17T15:25:25Z', 'Elsip');
INSERT INTO comments (video_author, video, comment, time, author) VALUES ('Urson Mottley', 'Best recipes', 'Tried it, burnt it' ,'2022-10-20T08:12:56Z', 'Stentiford');
INSERT INTO comments (video_author, video, comment, time, author) VALUES ('Thomas Eddison', 'Daily Dose of Internet', 'ahahaha' ,'2022-11-29T11:37:43Z', 'Pallent');
INSERT INTO comments (video_author, video, comment, time, author) VALUES ('Thomas Eddison', 'Daily Dose of Internet', 'Nice' ,'2022-10-31T03:42:06Z', '');
INSERT INTO comments (video_author, video, comment, time, author) VALUES ('Thomas Eddison', 'Daily Dose of Internet', 'OMG!' ,'2022-11-17T00:00:13Z', 'Stentiford');
INSERT INTO comments (video_author, video, comment, time, author) VALUES ('Clarissa Megan', 'Latest news today', 'Hope all is fine' ,'2022-11-12T10:21:12Z', 'Rosenblath');
INSERT INTO comments (video_author, video, comment, time, author) VALUES ('Clarissa Megan', 'Latest news today', 'Wow' ,'2022-11-27T13:23:23Z', 'Elsip');
INSERT INTO comments (video_author, video, comment, time, author) VALUES ('Clarissa Megan', 'Latest news today', 'Hope everyone is okay' ,'2022-11-19T15:15:33Z', 'Fiddeman');
INSERT INTO comments (video_author, video, comment, time, author) VALUES ('Mark Frank', 'League of Guardias Latest Update', 'Hate new patch, please fix' ,'2022-10-12T11:21:11Z', 'Pallent');
INSERT INTO comments (video_author, video, comment, time, author) VALUES ('Mark Frank', 'League of Guardias Latest Update', 'Finally some updates' ,'2022-11-21T21:21:12Z', 'Rosenblath');
INSERT INTO comments (video_author, video, comment, time, author) VALUES ('Stoddard Amys', 'Sad Song', 'Really beautiful' ,'2022-10-31T12:11:10Z', 'Stentiford');
INSERT INTO comments (video_author, video, comment, time, author) VALUES ('Stoddard Amys', 'Sad Song', 'So sad...' ,'2022-11-17T15:22:17Z', 'Fiddeman');

-- insert into table comments1:
INSERT INTO comments1 (video_author, video, comment, time, author) VALUES ('Aleph Paimon', 'no thoughs, head empty', 'Good vibes' ,'2022-10-17T15:22:17Z', 'Elsip');
INSERT INTO comments1 (video_author, video, comment, time, author) VALUES ('Aleph Paimon', 'no thoughs, head empty', 'Nice song' ,'2022-11-17T15:23:10Z', 'Fiddeman');
INSERT INTO comments1 (video_author, video, comment, time, author) VALUES ('Urson Mottley', 'Best recipes', 'Delicious' ,'2022-10-30T10:44:18Z', 'Stentiford');
INSERT INTO comments1 (video_author, video, comment, time, author) VALUES ('Urson Mottley', 'Best recipes', 'Have to try' ,'2022-11-17T15:25:25Z', 'Elsip');
INSERT INTO comments1 (video_author, video, comment, time, author) VALUES ('Urson Mottley', 'Best recipes', 'Tried it, burnt it' ,'2022-10-20T08:12:56Z', 'Stentiford');
INSERT INTO comments1 (video_author, video, comment, time, author) VALUES ('Thomas Eddison', 'Daily Dose of Internet', 'ahahaha' ,'2022-11-29T11:37:43Z', 'Pallent');
INSERT INTO comments1 (video_author, video, comment, time, author) VALUES ('Thomas Eddison', 'Daily Dose of Internet', 'Nice' ,'2022-10-31T03:42:06Z', 'Someone');
INSERT INTO comments1 (video_author, video, comment, time, author) VALUES ('Thomas Eddison', 'Daily Dose of Internet', 'OMG!' ,'2022-11-17T00:00:13Z', 'Stentiford');
INSERT INTO comments1 (video_author, video, comment, time, author) VALUES ('Clarissa Megan', 'Latest news today', 'Hope all is fine' ,'2022-11-12T10:21:12Z', 'Rosenblath');
INSERT INTO comments1 (video_author, video, comment, time, author) VALUES ('Clarissa Megan', 'Latest news today', 'Wow' ,'2022-11-27T13:23:23Z', 'Elsip');
INSERT INTO comments1 (video_author, video, comment, time, author) VALUES ('Clarissa Megan', 'Latest news today', 'Hope everyone is okay' ,'2022-11-19T15:15:33Z', 'Fiddeman');
INSERT INTO comments1 (video_author, video, comment, time, author) VALUES ('Mark Frank', 'League of Guardias Latest Update', 'Hate new patch, please fix' ,'2022-10-12T11:21:11Z', 'Pallent');
INSERT INTO comments1 (video_author, video, comment, time, author) VALUES ('Mark Frank', 'League of Guardias Latest Update', 'Finally some updates' ,'2022-11-21T21:21:12Z', 'Rosenblath');
INSERT INTO comments1 (video_author, video, comment, time, author) VALUES ('Stoddard Amys', 'Sad Song', 'Really beautiful' ,'2022-10-31T12:11:10Z', 'Stentiford');
INSERT INTO comments1 (video_author, video, comment, time, author) VALUES ('Stoddard Amys', 'Sad Song', 'So sad...' ,'2022-11-17T15:22:17Z', 'Fiddeman');