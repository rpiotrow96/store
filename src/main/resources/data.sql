INSERT INTO role VALUES
(1, 'ADMIN'),
(2, 'USER');

INSERT INTO user VALUES
(1, 1, 'admin@admin.pl', 'Admin', 'Admin', '$2a$10$iLpYZ2Xt9yNMXdQgJMI98OxkxUgmL2awfQjxwPNkLLed/7xeeRDFm'), --pass: 12345
(2, 1, 'user@user.pl', 'User', 'User', '$2a$10$iLpYZ2Xt9yNMXdQgJMI98OxkxUgmL2awfQjxwPNkLLed/7xeeRDFm'), --pass: 12345
(3, 1, 'user2@user.pl', 'User2', 'User2', '$2a$10$iLpYZ2Xt9yNMXdQgJMI98OxkxUgmL2awfQjxwPNkLLed/7xeeRDFm'); --pass: 12345

INSERT INTO user_role VALUES
(1, 1),
(2, 2),
(3, 2);

INSERT INTO product_type (name) VALUES
('Leki przeciwbólowe i przeciwzapalne');
INSERT INTO product_type (name) VALUES
('Leki na nadciśnienie');
INSERT INTO product_type (name) VALUES
('Leki na cukrzycę');
INSERT INTO product_type (name) VALUES
('Leki przeciwdepresyjne');
INSERT INTO product_type (name) VALUES
('Leki przeciwalergiczne');
INSERT INTO product_type (name) VALUES
('Antybiotyki');
INSERT INTO product_type (name) VALUES
('Leki na trawienie');
INSERT INTO product_type (name) VALUES
('Leki przeciwgrzybiczne');

INSERT INTO product (name, producer, description, prize, units_in_stock, available_amount, product_type_id) VALUES
( 'Ibuprom', 'USP zdrowie', 'Ibuprom lek polecany jest do stosowania w dolegliwościach bólowych różnego pochodzenia o nasileniu słabym do umiarkowanego. Lek obniża również gorączkę w przebiegu grypy, przeziębienia lub innych chorób zakaźnych.',
  20.00, 50, 1, 1);
INSERT INTO product (name, producer, description, prize, units_in_stock, available_amount, product_type_id) VALUES
( 'Aspirin', 'BAYER', 'Aspirin C to lek polecany w objawowym leczeniu dolegliwości bólowych i gorączki w przebiegu przeziębienia i grypy. Lek należy stosować od 12. roku życia.',
  25.00, 50, 50, 1);
INSERT INTO product (name, producer, description, prize, units_in_stock, available_amount, product_type_id) VALUES
( 'Ketonal Active', 'SANDOZ', 'Ketonal Active 50 mg lek przeciwbólowy i przeciwzapalny należy do grupy niesteroidowych leków przeciwzapalnych – NLPZ. Lek zawierają substancję czynną ketoprofen.',
  25.00, 50, 50, 1);
INSERT INTO product (name, producer, description, prize, units_in_stock, available_amount, product_type_id) VALUES
( 'Dexak', 'BERLIN-CHEMIE', 'Dexak lek przeciwbólowy, który należy do grupy niesteroidowych leków przeciwzapalnych (NLPZ), które wykazują działanie przeciwbólowe, przeciwzapalne i przeciwgorączkowe.',
  29.99, 50, 50, 1);

INSERT INTO product (name, producer, description, prize, units_in_stock, available_amount, product_type_id) VALUES
( 'Captopril Polfarmex', 'POLFARMEX', 'Lek stosowany na nadciśnienie tętnicze.',
  29.99, 50, 50, 2);
INSERT INTO product (name, producer, description, prize, units_in_stock, available_amount, product_type_id) VALUES
( 'Bisocard', 'VALEANT Polska ICN', 'Obniża ciśnienie tętnicze krwi, zwalnia czynność serca zarówno w spoczynku, jak i po wysiłku, a także obniża zapotrzebowanie mięśnia sercowego na tlen, przez co poprawia przepływ krwi przez naczynia wieńcowe serca i zmniejsza częstość występowania bólu w klatce piersiowej (dławicy piersiowej) u pacjentów z chorobą niedokrwienną serca (chorobą wieńcową).',
  29.99, 50, 50, 2);
INSERT INTO product (name, producer, description, prize, units_in_stock, available_amount, product_type_id) VALUES
( 'Amlozek', 'Adamed', 'Lek Amlozek jest wskazany w leczeniu wysokiego ciśnienia tętniczego (nadciśnienia tętniczego) lub bólu w klatce piersiowej, nazywanego dławicą piersiową, którego rzadko występującą postacią jest dławica piersiowa typu Prinzmetala (naczynioskurczowa). U pacjentów z wysokim ciśnieniem tętniczym lek rozszerza naczynia krwionośne, ułatwiając krwi przepływ przez nie. U pacjentów z chorobą niedokrwienną serca, lek Amlozek ułatwia dopływ krwi do mięśnia sercowego zwiększając ilość dostarczanego tlenu, co w rezultacie zapobiega bólowi w klatce piersiowej. Lek nie przynosi natychmiastowej ulgi w bólu dławicowym w klatce piersiowej.',
  29.99, 50, 50, 2);
INSERT INTO product (name, producer, description, prize, units_in_stock, available_amount, product_type_id) VALUES
( 'Triplixam', 'SERVIER', 'Produkt jest wskazany w leczeniu substytucyjnym nadciśnienia tętniczego samoistnego, u pacjentów, u których uzyskano kontrolę ciśnienia podczas stosowania peryndoprylu i indapamidu w produkcie złożonym oraz amlodypiny w oddzielnym preparacie, w takich samych dawkach jak w produkcie leczniczym.',
  29.99, 50, 50, 2);

INSERT INTO product (name, producer, description, prize, units_in_stock, available_amount, product_type_id) VALUES
( 'Metformax', 'Teva Pharmaceuticals Polska', 'Metformax to lek dostępny wyłącznie za okazaniem recepty. Wykorzystywany jest w leczeniu cukrzycy typu II. Jest objęty refundacją dla osób powyżej 75 roku życia. Pacjenci z tej grupy wiekowej mogą go otrzymać bezpłatnie we wszystkich wskazaniach refundacyjnych.',
  29.99, 50, 50, 3);
INSERT INTO product (name, producer, description, prize, units_in_stock, available_amount, product_type_id) VALUES
( 'Diaprel MR','SERVIER', 'Cukrzyca insulinoniezależna (typ 2) u osób dorosłych, kiedy przestrzeganie diety, ćwiczenia fizyczne oraz zmniejszenie masy ciała nie wystarczają do utrzymania prawidłowego stężenia glukozy we krwi.',
  29.99, 50, 50, 3);
INSERT INTO product (name, producer, description, prize, units_in_stock, available_amount, product_type_id) VALUES
( 'Janumet', 'Alvanaeko', 'Lek zawiera dwa leki przeciwcukrzycowe o komplementarnych mechanizmach działania, w celu zapewnienia lepszej kontroli glikemii u pacjentów z cukrzycą typu 2: fosforan sitagliptyny - inhibitor dipeptydylopeptydazy 4 (DPP-4) oraz metforminy chlorowodorek. Preparat pomaga wyrównać poziom glukozy u pacjentów z cukrzycą typu 2 jak również pomaga utrzymać wyższe stężenie insuliny po posiłku i zmniejszyć ilość produkowanego cukru w organizmie.',
  29.99, 50, 50, 3);
INSERT INTO product (name, producer, description, prize, units_in_stock, available_amount, product_type_id) VALUES
( 'Glucobay', 'BAYER', 'Doustny lek przeciwcukrzycowy. Lek zmniejszający stężenie glukozy we krwi (lek hipoglikemizujący); hamuje aktywności alfa-glukozydaz i spowalnia trawienie węglowodanów złożonych.',
  29.99, 50, 50, 3);

